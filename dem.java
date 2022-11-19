// import libraries
import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

// Making a class with name Average_age
public class Average_age {

	public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

		// private text gender variable which
		// stores the gender of the person
		// who died in the Titanic Disaster
		//private Text gender = new Text();
		String gender;
		int age;

		// private IntWritable variable age will store
		// the age of the person for MapReduce. where
		// key is gender and value is age
		//private IntWritable age = new IntWritable();

		// overriding map method(run for one time for each record in dataset)
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
		{

			// storing the complete record
			// in a variable name line
			String line = value.toString();

			// splitting the line with ', ' as the
			// values are separated with this
			// delimiter
			String str[] = line.split(",");//"\s+"

			/* checking for the condition where the
			number of columns in our dataset
			has to be more than 6. This helps in
			eliminating the ArrayIndexOutOfBoundsException
			when the data sometimes is incorrect
			in our dataset*/
			try
			{
				gender=str[4];
				if(Integer.parseInt(str[1])==0)
					age=Integer.parseInt(str[5]);
			}
			catch(Exception e)
			{
				gender="N/A";
				age=-1;
			}
			// writing key and value to the context
			// which will be output of our map phase
			context.write(new Text(gender), new IntWritable(age));
		}
	}

	public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {

		// overriding reduce method(runs each time for every key )
		public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException
		{

			// declaring the variable sum which
			// will store the sum of ages of people
			int avgAge = 0,sum=0;

			// Variable l keeps incrementing for
			// all the value of that key.
			int count = 0;

			// foreach loop
			for (IntWritable val : values) {
				count += 1;
				// storing and calculating
				// sum of values
				sum += val.get();
			}
			avgAge = sum / count;
			context.write(key, new IntWritable(avgAge));
		}
	}

	public static void main(String[] args) throws Exception
	{
		Configuration conf = new Configuration();

		Job job=Job.getInstance(conf);
		job.setJarByClass(Average_age.class);
		job.setJobName("Average Age");
		// job.setNumReduceTasks(0);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.waitForCompletion(true);
	}
}
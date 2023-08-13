# Hybrid_project

## Deployment Documentation: Python Flask Web Application with MySQL on PythonAnywhere

### Table of Contents
1. Introduction
2. Prerequisites
3. Steps for Deployment
   3.1. Prepare Your Project
   3.2. Create a PythonAnywhere Account
   3.3. Set Up a Virtual Environment
   3.4. Upload Your Project Files
   3.5. Install Dependencies
   3.6. Configure MySQL Database
   3.7. Configure Flask Application
   3.8. Configure Static Files and Templates
   3.9. Configure Web App and WSGI File
   3.10. Run Migrations
   3.11. Reload Your Web App
4. Conclusion
5. Additional Resources

### 1. Introduction
This documentation provides a step-by-step guide on how to deploy a Python Flask web application with a MySQL database on the PythonAnywhere hosting platform.

### 2. Prerequisites
- A Python Flask web application with necessary code and configurations.
- A MySQL database with relevant schema and data.
- Basic familiarity with Python, Flask, MySQL, and command-line operations.

### 3. Steps for Deployment

#### 3.1. Prepare Your Project
Ensure your Flask application code, static files, templates, and any other required assets are well-organized within a project folder.

#### 3.2. Create a PythonAnywhere Account
If you don't have an account on PythonAnywhere, sign up for one at https://www.pythonanywhere.com/registration/.

#### 3.3. Set Up a Virtual Environment
- Open a Bash console on PythonAnywhere.
- Create a virtual environment: `virtualenv venv`
- Activate the virtual environment: `source venv/bin/activate`

#### 3.4. Upload Your Project Files
Use the "Files" tab on PythonAnywhere to upload your project folder.

#### 3.5. Install Dependencies
Install required Python packages using pip:
```
pip install -r requirements.txt
```

#### 3.6. Configure MySQL Database
- Use the "Databases" tab on PythonAnywhere to set up your MySQL database.
- Note down the database hostname, username, password, and database name.

#### 3.7. Configure Flask Application
Modify your Flask application's configuration to use the MySQL database credentials obtained in the previous step.

#### 3.8. Configure Static Files and Templates
Configure your Flask app to correctly serve static files and templates.

#### 3.9. Configure Web App and WSGI File
- Use the "Web" tab on PythonAnywhere to create a new web app.
- Configure the web app to use your project's virtual environment.
- Set the WSGI file to point to your Flask app's entry point.

#### 3.10. Run Migrations
If your application requires database migrations, run them using Flask-Migrate or similar tools.

#### 3.11. Reload Your Web App
After completing the configuration steps, click the "Reload" button on the PythonAnywhere "Web" tab to apply your changes.

### 4. Conclusion
By following these steps, you've successfully deployed your Python Flask web application with a MySQL database on PythonAnywhere.

### 5. Additional Resources
Provide links to official documentation or resources related to Flask, MySQL, and PythonAnywhere to help users troubleshoot and enhance their deployment.

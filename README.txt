Selenium WebDriver, JUnit testing framework and Page Object concept were used to complete the task.
The following script is automated:
# GoogleCloudTest:
1. Open https://cloud.google.com/.
2. By clicking the portal search button at the top of the page, enter “Google Cloud Platform Pricing Calculator” in the search field.
3. Start the search by clicking the search button.
4. In the search results, click "Google Cloud Platform Pricing Calculator" and go to the calculator page.
5. Activate the COMPUTE ENGINE section at the top of the page.
6. Fill out the form with the following information:
       * Number of copies: 4
       *What are these instances for?: Leave blank.
       * Operating System/Software: Free: Debian, CentOS, CoreOS, Ubuntu or other user provided operating system.
       *VM class: Normal
       * Instance type: n1-standard-8 (vCPU: 8, RAM: 30 GB)
       * Select "Add GPUs".
           * Number of GPUs: 1
           *GPU type: NVIDIA Tesla V100.
       * Local SSD: 2x375 GB
       *Data Center Location: Frankfurt (Europe-West3)
       * Mandatory use: 1 year.
7. Click Add to Assessment.
8. Select EMAIL ASSESSMENT.
9. In a new tab, open https://10minemail.com or a similar service to create temporary emails.
10. Copy the email address generated in 10 Minute Mail.
11. Return to the calculator, enter the address from the previous paragraph in the Email field.
12. Click SEND E-MAIL.
13. Wait for the cost estimate email and check to see if the Total Estimated Monthly Cost in the email matches what appears in the calculator.

# PastebinTest:
Open https://pastebin.com
Create a New Paste with the following details:

* Code:
git config --global user.name "New Sheriff in Town"
git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
git push origin master --force

* Syntax Highlighting: "Bash"
* Paste Expiration: "10 Minutes"
* Paste Name / Title: "how to gain dominance among developers"
3. Save the paste and check the following:
* Browser page title matches Paste Name / Title
* Syntax highlighted for bash
* Check that the code matches the entered one


To run framework execute next command:
mvn -Denvironment=dev -Dsurefire.suiteXmlFiles=src/test/resources/testng_smoke.xml clean test

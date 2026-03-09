# AI Email Assistant - Chrome Extension and Web Application

This project contains 3 modules : 

1. email-writer-ext : A chromer extension asynchronously communicating with REST API of spring boot based email-writer-sb.
2. email-writer-react : A front-end web-application which takes email content as input and generates a reply for you as per the selected tone.
3. email-writer-sb : Spring Boot Java based REST API which uses Gemini 3.5 API to generate email response.

**Steps to run the project locally :**

**PRE-REQUISITES:**

Go to `ai.google.dev` and create a free Gemini API for yourself.

**(A).RUN - RUN THE BACK-END APPLICATION**
1. Clone the project on your local machine.
2. Open the cloned folder.
3. Preview hidden folders > Delete `.idea` file.
4. Open `email-writer-sb` in IntellijIDE.
5. Run the project once, let it fail.
6. Click on EmailWriterSbApplication > Edit Configurations > Environment Variable.
7. Write : `GEMINI_URL="https://generativelanguage.googleapis.com/v1beta/models/gemini-flash-latest:generateContent?key=";GEMINI_KEY={YOUR_API_KEY}` (i won't give mine, hehe).
8. Apply > OK.
9. Run and your backend will be live on `http://localhost:8080/api/email/generate`.
**(A).TEST - TEST THE BACK-END APPLICATION**
1. Install and Open Postman application.
2. Create a new collection and a 'POST' request with URL `http://localhost:8080/api/email/generate`
3. Give the payload in following format:
   `{
     "emailContent": "TEST EMAIL",
     "tone": "THE TONE YOU WANT IN REPLY"
   }`


**(B) RUN THE FRONT-END APPLICATION**
1. Open `email-writer-react` in VS Code or your preferred IDE.
2. Open `App.jsx` file within `email-writer-react` module.
3. Open intergrated terminal and run the command `npm run dev`.
4. Your Front-end Email reply generator will be now live on `http://localhost:5173/`.

**(C) ADDING CHROME EXTENSION TO YOUR BROWSER**
1. Open Chrome and navigate to `chrome://extensions/`.
2. Toggle Developer tool to "ON" on top right corner.
3. Click on Load unpacked option and upload the `email-writer-ext` module.
4. Right click the uploaded extension and pin it. 








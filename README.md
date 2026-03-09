# AI Email Assistant - Chrome Extension and Web Application

**Glimpse** - AI Email assistant helps you save time in writing email responses. It provides ready-to-send/Context fulfilling email template. I have used Gemini 3.5 API to build my email responses followed with an enhancement on Gmail's reply email box - Added a custom button `Kushagra's AI Reply` that further contacts with my backend `email-writer-sb`.

This project contains 3 modules : 

1. `email-writer-ext` : A chromer extension asynchronously communicating with REST API of spring boot based email-writer-sb.
2. `email-writer-react` : A front-end web-application which takes email content as input and generates a reply for you as per the selected tone.
3. `email-writer-sb` : Spring Boot Java based REST API which uses Gemini 3.5 API to generate email response.

**Steps to run the project locally :**

**PRE-REQUISITES:** Go to `ai.google.dev` and create a free Gemini API for yourself.

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
<img width="500" height="500" alt="Screenshot 2026-03-10 at 12 11 26 AM" src="https://github.com/user-attachments/assets/4b475b41-5fc5-496b-9748-b21e251507d3" />


**(B).RUN - RUN THE FRONT-END APPLICATION**
1. Open `email-writer-react` in VS Code or your preferred IDE.
2. Open `App.jsx` file within `email-writer-react` module.
3. Open intergrated terminal and run the command `npm run dev`.
4. Your Front-end Email reply generator will be now live on `http://localhost:5173/`.

**(B).TEST - TEST THE FRONT-END APPLICATION**
1. Open `App.jsx` on Live server `http://localhost:5173/`.
2. Give Payload and tone. 
3. Click on Generate Reply.

**(C).ADD - ADDING CHROME EXTENSION TO YOUR BROWSER**
1. Open Chrome and navigate to `chrome://extensions/`.
2. Toggle Developer tool to "ON" on top right corner.
3. Click on Load unpacked option and upload the `email-writer-ext` module.
4. Right click the uploaded extension and pin it.

**(C).TEST - TEST THE CHROME EXTENSION**
1. Open any of your email recieved on a google email account.
2. Click on reply.
3. Click on `Kushagra's AI Reply` button.
4. The Email box will get filled with relevant reply.
<img width="500" height="300" alt="Screenshot 2026-03-10 at 12 16 16 AM" src="https://github.com/user-attachments/assets/0c19305b-2dac-4fa8-b35e-725e20e8ee34" />

Thankyou so much for visiting this page !
Kushagra Mishra
kushagram3110@gmail.com








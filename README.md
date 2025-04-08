<img src="app/src/main/res/drawable/autiscan_logo.png" alt="Logo" width="200">

# AutiScan - Autism Spectrum Disorder (ASD) Screening App (Android + Cloud API)

This is an Android application for **Autism Spectrum Disorder (ASD) screening**, which uses a **cloud-based deep learning API** to analyze user responses and predict ASD risk. The backend is deployed on **Render**, and the Android client is built using **Kotlin** with **Retrofit** for API communication.

---

## 📱 Features

- Interactive ASD questionnaire
- Collects user demographics (age, gender, country, etc.)
- Sends data to a cloud API for screening
- Displays prediction result (Likely ASD / Unlikely ASD)
- Clean and user-friendly UI

---

## ☁️ Cloud Backend (API)

- **Model**: Deep Learning (TensorFlow Sequential)
- **Deployment**: Dockerized API hosted on [Render](https://render.com)
- **Framework**: FastAPI
- **Input Parameters**:
  - A1_Score to A10_Score
  - Age
  - Gender
  - Ethnicity
  - Jaundice history
  - Autism history in family
  - Country of residence
  - Used screening app before
  - Who is filling the form (relation)

---

## 📦 Tech Stack

| Layer         | Technology        |
|---------------|-------------------|
| Android App   | Kotlin + Retrofit |
| Backend API   | Python (FastAPI)  |
| Model         | TensorFlow        |
| Deployment    | Docker + Render   |

---

## 🔗 API Endpoint (Example)

```http
POST /predict
Content-Type: application/json
```
## 📤 Sample Request

```json
{
  "A1_Score": 1,
  "A2_Score": 0,
  "A3_Score": 1,
  "A4_Score": 1,
  "A5_Score": 0,
  "A6_Score": 1,
  "A7_Score": 1,
  "A8_Score": 0,
  "A9_Score": 1,
  "A10_Score": 1,
  "age": 24,
  "gender": "male",
  "ethnicity": "Asian",
  "jundice": "no",
  "austim": "no",
  "contry_of_res": "India",
  "used_app_before": "no",
  "result": "self",
  "relation": "self"
}
```

## ✅ Sample Response

```json
{
  "prediction": 0.84
}
```

---

## 🛠️ Setup & Usage
### 🔹 Android App

- Clone this repository.

- Open the project in Android Studio.

- In your Retrofit client, set the base URL to your Render API endpoint.

- Build and run on your emulator or Android device.

### 🔹 Backend API

- Clone the backend API repo (replace with your backend repo link).

- Build the Docker container:
```bash
docker build -t asd-api .
docker run -p 8000:8000 asd-api
```
- Deploy the container on Render (or any preferred platform).

- Use the Render API endpoint in your Android app.

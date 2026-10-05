# Protein Under 100

**An easy, phone-friendly guide to affordable protein in everyday Indian meals.**

> **Open the live app:** [boss974829.github.io/protein-under-100](https://boss974829.github.io/protein-under-100/)

Open that link on your phone to browse the foods, set a budget, and build a plate. You can also add it to your phone’s home screen from your browser’s share or menu options.

## Android app

The Android app opens the live site in a lightweight WebView. The latest debug-installable APK is available here:

**[Download Protein Under 100 for Android](https://github.com/boss974829/protein-under-100/raw/refs/heads/main/downloads/protein-under-100.apk)**

On Android, open the APK and follow the install prompt. If Android asks, allow your browser or file manager to install this app. This debug build is for direct installation and testing; it is not a Play Store release.

## What it does

- Browse 35+ vegetarian, egg, and non-vegetarian protein options.
- Compare estimated protein and serving costs, then search and filter by food group.
- Set a food budget and add servings to see the plate’s estimated protein and total spend.
- Get a rough adult daily protein estimate from body weight and see example combinations under ₹100.
- Explore simple meal ideas and a looping food illustration, with a control to pause its motion.
- Use the responsive layout on desktop, tablet, or phone.

## Run it locally

There is no build step or package install. Clone the repository, then serve the files from the project folder:

```bash
python -m http.server 8000
```

Open [http://localhost:8000](http://localhost:8000) in your browser.

## Deploy

The repository includes a GitHub Actions workflow that publishes the site to GitHub Pages when changes are pushed to `main`. After the first deployment finishes, the live app is available at:

**https://boss974829.github.io/protein-under-100/**

Changes to the Android project also trigger a GitHub Actions build, which updates the APK in `downloads/`.

If Pages is not enabled automatically, open the repository’s **Settings → Pages** and select **GitHub Actions** as the build and deployment source.

## About

Built by [Aditya Agrahari](https://github.com/boss974829), a software and AI enthusiast who enjoys making thoughtful digital experiences and useful tools.

## Nutrition and price notes

Protein amounts and prices are estimates for common portions; actual values vary by product, recipe, and location. The daily protein figure is a rough general adult estimate, not individualized medical advice. This site is not a substitute for advice from a qualified health professional.

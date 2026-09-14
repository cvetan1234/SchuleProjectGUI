# SchuleProjectGUI

A Java desktop application for translating between Bulgarian text and Morse code.

The application provides a graphical user interface built with Java Swing. It supports translation in both directions and can play the generated Morse code as audio using short and long signals.

## Features

- Translate Bulgarian text to Morse code
- Translate Morse code back to Bulgarian text
- Switch between the two translation directions
- Play Morse code as audio
- Support for Bulgarian letters, numbers, spaces, and common punctuation
- Graphical user interface built with Java Swing

## Technologies

- Java
- Java Swing
- Java Sound API

## Project Structure

- `smg_2/Translator.java` – main application, GUI, and translation logic
- `smg_2/Sound.java` – audio playback functionality
- `333_1+.WAV` – short Morse signal audio
- `333_3+.WAV` – long Morse signal audio
- `Mock_up.png` – GUI mock-up

## Requirements

A Java Development Kit (JDK) is required to compile and run the application.

You can check whether Java and the Java compiler are installed with:

```bash
java -version
javac -version
```

## Running the Application

Clone or download the repository and open a terminal in the root directory of the project.

Compile the application:

```bash
javac smg_2/Sound.java smg_2/Translator.java
```

Run the application:

```bash
java smg_2.Translator
```

## About

This project was originally developed as a school programming project and is preserved here as part of my programming portfolio.

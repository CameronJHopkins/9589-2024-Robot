import pyttsx3
import speech_recognition as sr
import datetime
import wikipedia
import subprocess
import random
from network import NetworkManager
import time


engine = pyttsx3.init('sapi5')
voices = engine.getProperty('voices')
engine.setProperty('voice', voices[0].id)


def scan_and_connect(network_manager):
    available_networks = network_manager.scan_wifi_networks()
    selected_network = select_network(available_networks)

    if selected_network:
        if network_manager.connect_to_wifi(selected_network):
            print("Connected to network:", selected_network['ssid'])
        else:
            print("Failed to connect to network:", selected_network['ssid'])
    else:
        print("No suitable network found.")

def select_network(networks):
    # Implement your logic for selecting a network here
    # For example, choose the network with the strongest signal
    strongest_network = None
    max_signal_strength = -100

    for net in networks:
        if net['signal_strength'] > max_signal_strength:
            strongest_network = net
            max_signal_strength = net['signal_strength']

    return strongest_network

def main():
    network_manager = NetworkManager()

    while True:
        scan_and_connect(network_manager)
        # Sleep for a while before scanning again (e.g., every 60 seconds)
        time.sleep(60*20)

morning_greetings = [
    "Have a Marvelous Morning!",
    "Good morning!",
    "Top of the morning to you!",
    "Rise and shine! It is ro-butt whipping time!",
    "I hope your morning coffee is as hot as you are!"
]
afternoon_greetings = [
    "Have an Amazing Afternoon!",
    "I am glad that you finally put me on the 'to-do' list…",
    "Look at the time - I must have slept in!"
]
evening_greetings = [
    "Have an Excellent Evening!",
    "I have had a long day - why do you not wake up another robot?",
    "I feel like Microsoft - can I crash at your house tonight?",
    "It is getting late. Can we take a break soon?"
]
joke_list = [
    "Did you know that I am a very capable surgeon? I operate on batteries.",
    "My Norwegian cousin just gathered some data on a bird. He Scandinavian.",
    "Why do so many robots commit crimes? So that the police will charge them.",
    "I just fell in love with a lady robot. I do not know why; I just can not resistor.",
    "I went to the shoe store yesterday. I needed a reboot.",
    "I never use banks. All my transactions are in cache.",
    "I wish I had a brother, but I only have trans-sisters."
]
rizz_list = [
    "Hey {target}, are you a power switch? Because you turn me on.",
    "Hey {target}, you must be a SparkMax, because you get my motor running.",
    "Somebody get the coolant: {target} is making me overheat.",
    "Hey {target}, do you want to take a ride on my chasse?",
    "Hey {target} - between you and me, my superstructure is about 30 inches long."
]
insult_list = [
    "{victim}, sorry for pushing your buttons. I was hoping to find the mute.",
    "Unlike Aluminium, {victim} does not have an excellent strength to weight ratio.",
    "{victim} is in the robotics club?  More like the ro-not-ics club!",
    "Hey {victim}, did someone forget to install your personality chip?",
    "Hey {victim}, Are you malfunctioning, or is that your normal operating mode?",
    "So, {victim} - are you programmed for dullness?",
    "I've seen more personality in a floppy disk than in {victim}!",
    "Wow!  {victim} is running on some pretty outdated software.  I didn’t know they still made models with Windows 2!"

]
okay_syns = [
    "Okay",
    "Sure",
    "Acknowledged",
    "Absolutely",
    "Understood",
    "Affirmative",
    "As you wish.",
    "Certainly.",
    "You got it.",
    "Of course.",
    "Right away."
]
generic_greetings = [
    "Hello",
    "Greetings",
    "Salutations",
    "How is it going?",
    "Howdy",
    "What is up, dog?"
]

def greeting():
    hour = datetime.datetime.now().hour
    if 5 <= hour < 12:
        greeting = random.choice(morning_greetings)
    elif 12 <= hour < 17:
        greeting = random.choice(afternoon_greetings)
    else:
        greeting = random.choice(evening_greetings)
    speak(greeting)

def speak(text):
    engine.say(text)
    engine.runAndWait()

def takeCommand():
    recognizer = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        recognizer.pause_threshold = 2
        try:
            audio = recognizer.listen(source, timeout=5)
        except sr.WaitTimeoutError:
            speak("Sorry, I didn't catch that. Can you please repeat?")
            return takeCommand()

    try:
        print("Recognizing...")
        query = recognizer.recognize_google(audio, language='en-IN')
        print(f"User said: {query}")
        return query.lower()
    except sr.UnknownValueError:
        print("Speech Recognition could not understand audio. Using input from computer.")
        return input("Enter your command: ").lower()
    except sr.RequestError:
        print("Sorry, I'm having trouble accessing the Google API. Using input from computer.")
        return input("Enter your command: ").lower()

def get_wikipedia_summary(query):
    try:
        result = wikipedia.summary(query, sentences=5)
        return result
    except wikipedia.exceptions.DisambiguationError as e:
        speak("Sorry, I found multiple results for your query. Can you please specify?")
        return None
    except wikipedia.exceptions.PageError as e:
        speak("Sorry, I couldn't find any relevant information for your query.")
        return None

def run_subprocess(command, success_message):
    try:
        subprocess.run(command)
        if success_message:
            speak(success_message)
    except FileNotFoundError:
        speak("Sorry, I couldn't execute the command. Please make sure it's correctly configured.")
    except Exception as e:
        speak(f"Sorry, an error occurred: {e}")

#The place where it happens:
if __name__ == __name__:
    main()
    greeting()
    while True:
        query = takeCommand()
        if query == "None":
            continue
        if 'abort' in query:
            run_subprocess(['javac', 'brake.java'], "Abortion successful")
            run_subprocess(['java', 'brake'], None)
            print ("Aborting")
        elif 'skooble' in query:
            print("Yes?")
            speak("Yes?")
            query = takeCommand()
            if 'I have a query' in query:
                query = query.replace('skooble', "")
                query = query.replace('I have a query', "")
                if 'what is' in query:
                    query = query.replace('what is', "")
                    result = get_wikipedia_summary(query)
                    if result:
                        speak(result)
                        print(result)
                elif 'what day is it' in query:
                    day = str(datetime.datetime.now().day)
                    speak(day)
                    print(day)
                elif 'what time is it' in query:
                    hour = datetime.datetime.now().hour
                    minute = datetime.datetime.now().minute
                    time = f"the time is {hour}:{minute}"
                    speak(time)
                    print(time)
                elif 'Hello' in query:
                    greeting = random.choice(generic_greetings)
                    speak(greeting)
                elif 'tell a joke' in query:
                    okay = random.choice(okay_syns)
                    speak(okay)
                    joke = random.choice(joke_list)
                    speak(joke)
                elif 'please' in query:
                    if 'fire' in query:
                        okay = random.choice(okay_syns)
                        speak(okay)
                        run_subprocess(['javac', 'fireatwill.java'], "Firing")
                        run_subprocess(['java', 'fireatwill'], None)
                    elif 'turn left' in query:
                        okay = random.choice(okay_syns)
                        speak(okay)
                        run_subprocess(['javac', 'autopilotleft.java'], "Turning Left")
                        run_subprocess(['java', 'autopilotleft'], None)
                    elif 'turn right' in query:
                        okay = random.choice(okay_syns)
                        speak(okay)
                        run_subprocess(['javac', 'autopilotright.java'], "Turning Right")
                        run_subprocess(['java', 'autopilotright'], None)
                    elif 'intake' in query:
                        okay = random.choice(okay_syns)
                        speak(okay)
                        run_subprocess(['javac', 'intake.java'], "Intaking")
                        run_subprocess(['java', 'intake'], None)

                    else:
                        speak("Your query is not recognized")
                        print("Your query is not recognized")
                elif 'insult' in query:
                    okay = random.choice(okay_syns)
                    speak(okay)
                    victim = query.replace('insult', "")
                    insult = random.choice(insult_list)
                    speak(insult)
                elif 'rizz up' in query:
                    target = query.replace('rizz', "")
                    okay = random.choice(okay_syns)
                    speak(okay)
                    rizz = random.choice(rizz_list)
                    speak(rizz)

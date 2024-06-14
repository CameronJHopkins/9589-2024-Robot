
# This is an alternative to AudioComparison.java, but it requires additional dependencies to be installed for usage.





# import subprocess
# import aubio
# import numpy as np
# import pyaudio
# import wave
# import os

# def record_audio(filename, duration=5, chunk=1024, channels=1, rate=44100):
#     audio = pyaudio.PyAudio()

#     stream = audio.open(format=pyaudio.paInt16,
#                         channels=channels,
#                         rate=rate,
#                         input=True,
#                         frames_per_buffer=chunk)

#     frames = []

#     print("Recording...")

#     for i in range(0, int(rate / chunk * duration)):
#         data = stream.read(chunk)
#         frames.append(data)

#     print("Finished recording.")

#     stream.stop_stream()
#     stream.close()
#     audio.terminate()

#     wf = wave.open(filename, 'wb')
#     wf.setnchannels(channels)
#     wf.setsampwidth(audio.get_sample_size(pyaudio.paInt16))
#     wf.setframerate(rate)
#     wf.writeframes(b''.join(frames))
#     wf.close()

# def fingerprint_audio(audio_file):
#     # Set up parameters for aubio
#     samplerate = 44100
#     hop_size = 512
#     win_size = 1024
#     s = aubio.source(audio_file, samplerate, hop_size)
#     samplerate = s.samplerate

#     # Initialize aubio's pitch detection
#     tolerance = 0.8
#     pitch_o = aubio.pitch("yin", win_size, hop_size, samplerate)
#     pitch_o.set_tolerance(tolerance)

#     # Read audio and compute pitch
#     pitches = []
#     while True:
#         samples, read = s()
#         pitch = pitch_o(samples)[0]
#         pitches.append(pitch)
#         if read < hop_size:
#             break

#     # Convert pitches to numpy array
#     pitches = np.array(pitches)

#     # Convert pitches to fingerprint format
#     fingerprint = tuple(pitches)

#     return fingerprint

# def compare_audio(fingerprint1, fingerprint2):
#     # Compare the two fingerprints
#     similarity = np.sum(np.abs(np.array(fingerprint1) - np.array(fingerprint2)))
#     return similarity

# def run_command(command):
#     subprocess.run(command, shell=True, stderr=subprocess.PIPE)

# def check_microphone():
#     try:
#         audio = pyaudio.PyAudio()
#         devices = audio.get_device_count()
#         if devices > 0:
#             print("Microphone found.")
#             return True
#         else:
#             print("No microphone detected.")
#             return False
#     except Exception as e:
#         print("Error checking microphone:", e)
#         return False

# if __name__ == "__main__":
#     if check_microphone():
#         # Commands and associated files
#         commands = {
#             "Stop": "C:\The coding one\Skooble\src\main\java\frc\robot\Commands\brake.java",
#             "Fire": "C:\The coding one\Skooble\src\main\java\frc\robot\Autos\fireatwill.java",
#             # Add more commands and associated files as needed
#             "Abort-Command":"C:\The coding one\Skooble\src\main\WAV\Abort.wav",
#             "Fire-Command":"C:\The coding one\Skooble\src\main\WAV\Fire-Command.wav",
#         }

#         # Record audio from microphone
#         recorded_audio_file = "recorded_audio.wav"
#         record_audio(recorded_audio_file)

#         # Fingerprint recorded audio
#         recorded_fingerprint = fingerprint_audio(recorded_audio_file)

#         # Compare recorded audio fingerprint with pre-recorded audio fingerprints
#         for command, file in commands.items():
#             pre_recorded_audio_file = f"path/to/{file}"
#             pre_recorded_fingerprint = fingerprint_audio(pre_recorded_audio_file)

#             similarity = compare_audio(pre_recorded_fingerprint, recorded_fingerprint)

#             # Adjust the threshold as needed
#             if similarity < 1000:
#                 print(f"Executing {command}...")
#                 if command == "Abort-Command":
#                     run_command("Stop")
#                 elif command == "Fire-Command":
#                     run_command("Fire")
#                 else:
#                     run_command(file)
#                 break

#         else:
#             print("Captured audio does not match any pre-recorded audio.")
#     else:
#         print("Cannot run the script without a microphone.")

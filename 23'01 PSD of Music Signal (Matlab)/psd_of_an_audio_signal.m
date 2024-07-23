clc;
clear;
close all;
voice= audiorecorder(22050,8,1); 
disp('Start recording'); %To start speaking
recordblocking(voice,10); %Stops the recording after 20 seconds
disp('End recording'); %Message displays end of recording
a= getaudiodata(voice); %Gets the data of voice signal and stores in a variable 'a'
figure;
plot(a); %Plots a graph of the voice signal
title('Audio signal');
xlabel('time in sec');
ylabel('Amplitude');
b=pwelch(a);
plot(b);
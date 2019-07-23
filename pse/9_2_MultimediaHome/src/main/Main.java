/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , First test
>
> %% 2017.11.14
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> First test of the Practical Software Engineering course.
>
> %% I declare that this solution is my own work.
>
> %% I have not copied or used third party solutions.
>
> %% I have not passed my solution to my classmates, neither  made it public.
>
> %% Students’ regulation of Eötvös Loránd University (ELTE Regulations
> Vol. II. 74/C. § ) states that as long as a student presents another
> student’s work - or at least the significant part of it - as his/her own
> performance, it will count as a disciplinary fault. The most serious

> consequence of a disciplinary fault can be dismissal of the student from
> the University."

*/


package main;

import multimediahome.SetTopBox;
import multimediahome.GameConsole;
import multimediahome.TV;
import multimediahome.TVChannel;

public class Main {

    public static void main(String[] args) {
        TVChannel sport = new TVChannel("Sport", 3);
        TVChannel news = new TVChannel("News", 5);
        TVChannel cinema = new TVChannel("Cinema", 9);

        SetTopBox broadcastCompany = new SetTopBox();
        broadcastCompany.addTVChannel(sport);
        broadcastCompany.addTVChannel(news);
        broadcastCompany.addTVChannel(cinema);

        GameConsole gameConsole = new GameConsole();

        TV tv = new TV();

        tv.turnOn();
//        TV turned on. Volume: 5
//        Display[Coax]: NO SIGNAL

        tv.autoTuneChannels();
//        Tuning... frequency=0...
//        Tuning... frequency=1...
//        Tuning... frequency=2...
//        Tuning... frequency=3...
//        Tuning... frequency=4...
//        Tuning... frequency=5...
//        Tuning... frequency=6...
//        Tuning... frequency=7...
//        Tuning... frequency=8...
//        Tuning... frequency=9...
//        Tuning... frequency=10...
//        No channels found. Did you plug a coax cable in?
//        Display[Coax]: NO SIGNAL

        tv.pluginCable(broadcastCompany);
        tv.pluginCable(gameConsole);

        tv.autoTuneChannels();
//        Tuning... frequency=0...
//        Tuning... frequency=1...
//        Tuning... frequency=2...
//        Tuning... frequency=3 added Sport to Channel-1
//        Tuning... frequency=4...
//        Tuning... frequency=5 added News to Channel-2
//        Tuning... frequency=6...
//        Tuning... frequency=7...
//        Tuning... frequency=8...
//        Tuning... frequency=9 added Cinema to Channel-3
//        Tuning... frequency=10...
//        Display[Coax]: Sport

        tv.changeChannel(3);
        tv.showPicture(); // Display[Coax]: Cinema

        tv.switchInput();
        tv.showPicture(); // Display[HDMI]: NO SIGNAL

        gameConsole.turnOn();
        tv.showPicture(); // Display[HDMI]: No game loaded

        gameConsole.loadGame("Call of Duty");
        tv.showPicture(); // Display[HDMI]: Call of Duty
        tv.autoTuneChannels(); // Auto tune on HDMI is not supported.
        tv.changeChannel(0); // Channel change on HDMI is not supported.

        tv.increaseVolume(); // Volume: 6
        tv.increaseVolume(); // Volume: 7
        tv.increaseVolume(); // Volume: 8
        tv.increaseVolume(); // Volume: 9
        tv.increaseVolume(); // Volume: 10
        tv.increaseVolume(); // Volume: 10

        tv.turnOff(); // TV turned off.
        tv.turnOn();
        // TV turned on. Volume: 10
        // Display[HDMI]: Call of Duty
    }

}

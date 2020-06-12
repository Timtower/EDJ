
[download-shield]: https://img.shields.io/github/v/release/XenoPyax/EDJ
[download]: https://github.com/XenoPyax/EDJ/releases
[license]: https://github.com/XenoPyax/EDJ/blob/master/LICENSE
[license-shield]: https://img.shields.io/github/license/XenoPyax/EDJ
[faq]: https://github.com/XenoPyax/EDJ/wiki
[faq-shield]: https://img.shields.io/badge/Wiki-FAQ-blue.svg

[ ![download-shield][] ][download] [ ![license-shield][] ][license] [ ![faq-shield] ][faq]

# Welcome to Elite Dangerous Java API <img align=right src="https://i.imgur.com/C6hP0fT.png">
I am a second year Java Development student and also a Double Elite Commander. I am always trying to make new 3rd Party Applications for ED, so I started making my very own ED Java API. Not only to see if I can do it but also to maybe helps some of you out there that don't want to go through this tedious part of their App.

## What does it do?
Elite: Dangerous Java API *short EDJ* is a simple API that reads the playerjournals provided by the game and listens for when new lines are added to the file. This API will allow you to register `EventListeners` to listen to specific events that occur and process the journals written data. For more information on how to use this API have a look at [How to use EDJ?](#how-to-use-edj?)

## How can Non-programmers contribute?
If you have no programming knowledge you can contribute by sending me your player journal with the missing entries found in the Trello Board and I will add them to the API as soon as I find time. [Here](https://trello.com/b/C1LH0xg4/edj-elite-dangerous-java-api) is a link to my Trello board with the current progress and event coverage.

## How to use EDJ?
First we have to create a listener which tells the api what you want to do with the data.
```
public class FSDJumpListener extends EventListener {
	
    @Override
    public void onFSDJump(FSDJumpEvent event) {
    	
        //TODO: process the data in event
        
    }
    
}
```
Now we create the API with the help of the `EDJApiBuilder` class where we register the listener we just created.
```
EDJApi api = new EDJApiBuilder(true) // Create a EDJApiBuilder object with the debug option enabled or disabled
		.addListeners(new FSDJumpListener()) // add your listener classes to the api
		.build(); // Building The API
```

That's it! Now the API will run the code defined in the EventListeners whenever that event is called.

## Authors & Contributors

* **Gabriel Smith** - Initial work - [XenoPyax](https://github.com/XenoPyax)
* **drh713** - submitted 90+ missing event strings - [u/drh713](https://www.reddit.com/user/drh713/)

*Also see here for a list of all [contributors](https://github.com/XenoPyax/EDJ/contributors) of EDJ.*

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE) file for details

----
###### Got any ideas or want to chat? DM me on Discord *XenoPyax#5647* or send me one on Twitter [@xenopyax](https://twitter.com/XenoPyax).

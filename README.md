LightningBolt
=============
A lightning bolt test using Slick2D, OpenGL, and LWJGL libraries, using algorithms influenced by a blog post by Drillian's House of Game Developement (http://drilian.com/2009/02/25/lightning-bolts/). Sometimes I just want to develop a simple idea, and maybe it will have a purpose later, and I usually learn something. 

Navigation
----------
[LightningBolt](#lightningbolt) |
[Author](#author) |
[Requirements](#requirements) |
[Folder Structure](#folder-structure) |
[Installation](#installation) |
[Usage](#usage) |
[Contributions](#contributions) |
[Todo](#todo) |
[Licence](#licence) |
[Contact](#contact)

Author
------
Joshua Michael Waggoner (@rabbitfighter81)

Requirements
------------
<ul>
<li> Java vers 1.7+ </l1>
<li> Gradle vers 2.0+ (for installation help go to <a href="https://gradle.org/"></a>
<li> Slick2D Libraries (downloaded automatically with git clone)</li>
<li> LWJGL Libraries and natives (included in Slick2D download)</li>
<li> OpenGL compatible graphics (you probably have this)</li>
</ul>

Folder Structure
----------------
<pre>
.
├── build.gradle
├── libs
│   ├── jar
│   │   ├── lwjgl.jar
│   │   ├── lwjgl_util.jar
│   │   └── slick.jar
│   └── natives
│       ├── linux
│       │   ├── libjinput-linux64.so
│       │   ├── libjinput-linux.so
│       │   ├── liblwjgl64.so
│       │   ├── liblwjgl.so
│       │   ├── libopenal64.so
│       │   └── libopenal.so
│       ├── macosx
│       │   ├── libjinput-osx.dylib
│       │   ├── liblwjgl.dylib
│       │   └── openal.dylib
│       └── windows
│           ├── jinput-dx8_64.dll
│           ├── jinput-dx8.dll
│           ├── jinput-raw_64.dll
│           ├── jinput-raw.dll
│           ├── lwjgl64.dll
│           ├── lwjgl.dll
│           ├── OpenAL32.dll
│           └── OpenAL64.dll
├── LICENSE
├── README.md
└── src
    └── main
        └── java
            └── net
                └── rabbitfighter
                    └── lightning
                        └── LightningBolt.java

12 directories, 24 files
</pre>

Installation
------------
<ol>
<li>Clone this git repo using <code>git clone ...</code></li>
<li>Navigate into the project's root directory and build using 
	<code>gradle build</code></li>
</ol>

Usage
-----
To run, from the project's root directory, use the command <code>gradle run</code>

Contributions
-------------
I would love for other people to contribute to this and see what kind of cool lightning effects we could get going. Fork this, or make a pull request. :)


Todo
----
This is purely an experimental test to play with ways of creating lightning effects for gaming. 

Licence
-------
CCO

Contact
-------
Email: <a href="rabbitfighter@cryptolab.net">rabbitfighter@cryptolab.net</a>

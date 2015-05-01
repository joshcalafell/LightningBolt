LightningBolt
=============

Navigation
----------
[LightningBolt](#lightningbolt) |
[Author](#author) |
[Usage](#usage) |
[Folder Structure](#folder-structure) |
[Todo](#todo)

Author
------
Joshua Michael Waggoner (@rabbitfighter81)


A lightning bolt test using Slick2D, OpenGL, and LWJGL libraries, using algorithms influenced by a blog post by Drillian's House of Game Developement (http://drilian.com/2009/02/25/lightning-bolts/). Sometimes I just want to develop a simple idea, and maybe it will have a purpose later, and I usually learn something. 

Usage
-----
Slick2D, and LWJGL are required. 

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

Todo
----

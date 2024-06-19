## Start with pull the image first 
You will recognize that in the Internet there 2 types of jenkins image (1. docker pull jenkins[https://hub.docker.com/_/jenkins]) and (2. docker pull jenkins/jekins[https://hub.docker.com/r/jenkins/jenkins]). <br>

First, both images are sill work properly, but the first one is deprecated for over 2 years so that if you want to use latest version of Jenkins, try the second one.

## Jenkins is quite big, even when you are setting up by your Own

So that pulling this image may take longer than you thing. Just relax and pay your time, I promise this image will become the most valuable thing in your docker hub from now on.

## Name the new docker container as (jenkins) or anything you want and start our new journey

```docker run -p 8080:8080 -p 50000:50000 --restart=on-failure --name=jenkins jenkins/jenkins:lts-jdk17```

In here I will explain some new things for you guys:
#### 1. --restart=on-failure
Nothing much to talk about this. But I will give you some others values that you can use next time. <br>
always: Always restart the container if it stops.
unless-stopped: Always restart the container unless it was stopped arbitrarily, or by the Docker daemon.

## Password

If you have downloaded Jenkins into your computer, you will know that we will need to take the password from the system32 folder, but with this image, you can get it from your cmd. Notice, this is 1 time-run password, it means this password will be reset next time you run this container up.

## Plugins and fishing

An old men told me that, waiting for jenkins to install its plugin is the same as wasting your time on fishing with Molley, cause it useless.
But one more time, keep safe every things and save your time by don't choose install custom plugins.

## Admin User

This admin information is quite important, so that try to make it simple as possible so that you can use it next time. <br>
Next thing you will see they ask us to choose a URL, for not conflicting in the future, we will want to set it as ```localhost:8080/jenkins```

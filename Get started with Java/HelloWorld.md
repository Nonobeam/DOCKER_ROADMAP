# Run our first Java application using Docker
## What I will use in this tutorial
- Visual Studio Code
- A basic Hello World java application

Both the Hello World project and the finished Docker file are in the Sample Project folder, you can either make your own application or use the pre-made one for this tutorial.

## Create our dockerfile
To do that, simply create a new file inside your project folder and name it "dockerfile". If you use Visual Studio Code or similar IDE, you will see that as soon as will create a new file and name it "dockerfile" the file that you have just created will automatically turn into a docker file.

## Upload our project into Docker

### Use a base image
A base image is a starting point or an initial step for the image that you want to create. The reason why in most cases we use a base image is because it is easier and faster to use an existing image that has the files and dependencies that you need, rather than creating everything from scratch. To use a base image, first write the ```FROM``` and then after that is the base image that you want to use. 

In this tutorial, I will be using an image from the official Docker Hub, which houses a lot of images for all operating and programming language that you want to use for your application. I will assume that you want to run a Java application on Docker, I will use **openjdk:11**, the **openjdk** is the image that you want to use and the **:11** specify the version of that base image (note: if you do not want a specific version in your image, simply leave it out and docker will automatically take the latest version from that base image)

```dockerfile
  #Use the openjdk 20 image as base image
  FROM openjdk:20
```

### Create a new directory 

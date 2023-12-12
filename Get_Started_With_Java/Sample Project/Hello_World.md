# Run our first Java application using Docker
## What I will use in this tutorial
- Visual Studio Code
- A basic Hello World java application

A Hello World project is prepared for you in the Sample_Project folder, you can either make your own application or use the pre-made one for this tutorial.

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
Next we create a new directory using the RUN command

```dockerfile
# Create a new directory under the name "app" using Run
RUN mkdir /app
```
Note:
* the ```RUN``` Command is used to execute commands in a new layer on top of the current image and commit the result. The subsequent steps will be built on top of that current layer. You can have as many ```RUN``` command as you want when you build your image
* Here we are building a new directory using ```mkdir``` with the name "/app"

### Copy all the relevant code from the source to our directory in Docker
To do that, we will now use the ```COPY``` command to copy all of the source code from your local machine to the destination, which is your intending directory
```dockerfile
#Copy the source file(s) or folder(s) from your machine to your image
COPY src/main/java/com/helloworld/HelloWorld.java /app
```
### Set your working directory
The ```WORKDIR``` instruction in a Dockerfile sets the current working directory for subsequent instructions in the Dockerfile. It is useful for organizing your files and dependencies in a consistent and predictable way
```
#Create a work directory to execute future commands
WORKDIR /app
```
### Run your main class
At the end of every dockerfile, there must be one ```CMD``` command or ```ENTRYPOINT``` command, which are both used to specify the command that will be executed when a Docker container is run.
```
#Run our HelloWorld file
CMD [ "java", "HelloWorld.java" ]
```
## Build your image
Here is the finished dockerfile's code
```
#Use the openjdk 20 image as base image
FROM openjdk:20

# Create a new directory under the name "app" using Run
RUN mkdir /app

#Copy the source file(s) or folder(s) from your machine to your image
COPY src/main/java/com/helloworld/HelloWorld.java /app

#Create a work directory to execute future commands
WORKDIR /app

#Run our HelloWorld file
CMD [ "java", "HelloWorld.java" ]

```
Now we are ready to build our image. If you are using VS Code you can either right click and select build image or use the terminal. I will show you how to build the image using the terminal in this tutorial.
### Build the image using the terminal
Open the terminal using VS code, we type:
```
docker build -t hello_world:1.0 .
```
Note: 
* **-t** is used to name our image, in this case is hello_world.
* We can specify which version is it by following up with a **:** or we can leave it as it and it will default to "latest" tag.
* the . is where we specify the path where the Dockerfile is located, since we are already in the directory where the Dockerfile is located, we can simply leave it as a dot.

## Run our Docker image
Finally, we can either go to the GUI for Docker to run the image there or we can run it using the terminal
```terminal
docker run hello_world
```

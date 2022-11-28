FROM ubuntu:latest
# Install dependencies
RUN apt-get update
RUN apt-get install -y \
    sudo \
    openjdk-17-jdk \
    maven \
    git \
    gpa \
    seahorse \
    curl \
    openssh-server
# Remove apt cache
RUN rm -rf /var/lib/apt/lists/*
# Create users
RUN useradd -rms /bin/bash -G sudo remote
# Set passwords
RUN echo remote:passpass | chpasswd
# Expose ports
EXPOSE 22
# Create workspace directory and set permissions
RUN mkdir /home/remote/workspace && chown -R remote:remote /home/remote/workspace
# set up ssh daemon to run in the foreground
CMD ["service", "ssh", "start", "-D"]
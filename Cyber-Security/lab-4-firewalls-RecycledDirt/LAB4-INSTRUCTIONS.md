## Lab 4 : CEG 3400

### The Terminalator

Table of contents:
* [Background](LAB4-INSTRUCTIONS.md#background)
* [Objectives](LAB4-INSTRUCTIONS.md#objectives)
* [Preparation](LAB4-INSTRUCTIONS.md#preparation)
* [Task 1: A Shell Game](LAB4-INSTRUCTIONS.md#task-1-a-shell-game)
* [Task 2: Iptables](LAB4-INSTRUCTIONS.md#task-2-iptables)
* [Task 3: Any Port in a Storm](LAB4-INSTRUCTIONS.md#task-3-any-port-in-a-storm)

---

#### Background and Objectives

In this lab you will learn about some basic (and more advanced) network manipulation 
tools by catpuring and creating packets, and exploring a well documented type of 
attack.

This lab assumes you have a basic understanding of networking, IP addresses, ports
and packets (from CEG-2350 and what was covered in class).

Students should become familiar with the following:

* configuring iptables (firewalls)
* abusing netcat and pipes
* creating, sending, and capturing packets with Scapy

---

#### Rubrik
| Item | # Points|
| --- | --- |
| 10 commits | 10 |
| Good markdown style | 20 |
| Task 1 | 30 |
| Task 2 | 30 | 
| Task 3 | 30 |
| EC     | 20 |

---

### Preparation

This lab will require some work be done in AWS!  For those of you unfamiliar with AWS please see the following guide:

* [AWS Guide for CEG 3400](AWS.md) 

Please deploy the below instance and work inside the lab.

* [CEG 3400 Lab 4 AWS link](https://console.aws.amazon.com/cloudformation/home?region=us-east-1#/stacks/new?stackName=ceg3400Lab&templateURL=https:%2F%2Fwsu-cecs-cf-templates.s3.us-east-2.amazonaws.com%2Fcourse-templates%2Fceg3400-mek.yml)
* Identify the IP address of the running EC2 instance created [in the EC2
  page](https://console.aws.amazon.com/ec2/v2/home?region=us-east-1#Instances:)

---

## Task 1: A Shell Game

You find the following command in the command history on one of your systems:

```
rm /tmp/f; mkfifo /tmp/f; cat /tmp/f | /bin/sh -i 2>&1 | nc -l 1234 >/tmp/f
```

Investigate this command by running it on your AWS system.  While it is running scan the
***PUBLIC*** IP address of your AWS instance.

A security researcher mentioned that an outbreak of Bind and Reverse shells have been cropping 
up on your network recently.  Do some research on ***Bind Shells*** and ***Reverse Shells***.

After you have an understanding of what a Bind shell and reverse shell are see if you can 
make this one respond!

Hint: Try connecting to the opened port with `nc` from a different system.  (We will be covering `nc` usage on Thursday, but it is a simple command if you want to tackle it before then.

Answer all questions in `README.md`.

---

## Task 2: Iptables

Clearly the previous command should not be left running.  But we can do better.

Using `iptables` and the `REJECT` action, block all incoming access to the malicious shell port on your AWS system.

Hint: you can craft a single `iptables` command or you can use `iptables-save` 
and `iptables-restore` to simplify saving the full firewall rules list.

---

## Task 3: Any Port in a Storm

After successfully blocking that shell your crack team of security researchers start 
seeing more malicious shells running on other ports.  Before you can start yelling at
your co-workers you need to lock your system down.

Identify all NEEDED ports for your standard communications with this server (SSH) and 
block ***ALL OTHER PORTS*** in the same manner as task 2 using the `REJECT` action.

***Hint:*** you will likely mess this up when deploying, be sure to document and 
`git commit` / `git push` all files including your final task 4 iptables-rules file 
before attempting this task.  If you lock yourself out that is OK, a reboot should fix it.

---

## Extra Credit

Using scapy (which may need to be installed on your AWS system), capture a packet using `sniff()` 
that contains either a command being sent to your malicious shell, or a response to a command.

Print the contents of the packet using `show()` and describe what the command/response is.  Include
this `show()` and any other data used in determining the contents of the packet.

**All EC questions must be answered to recieve any extra credit.**  I will not be grading partially finished EC.



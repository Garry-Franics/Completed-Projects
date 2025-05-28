# Lab 6 : CEG 3400

## Risk

Table of contents:
* [Background](LAB6-INSTRUCTIONS.md#background)
* [Objectives](LAB6-INSTRUCTIONS.md#objectives)
* [Rubric](LAB6-INSTRUCTIONS.md#rubric)
* [Preparation](LAB6-INSTRUCTIONS.md#preparation)
* [Task 1: Home sweet home](LAB6-INSTRUCTIONS.md#task-1-home-sweet-home)
* [Task 2: Platform Inventory](LAB6-INSTRUCTIONS.md#task-2-platform-inventory)
* [Task 3: Guess who](LAB6-INSTRUCTIONS.md#task-3-guess-who)
* [Task 4: Eventually](LAB6-INSTRUCTIONS.md#task-4-eventually)
* [Task 5: Impact](LAB6-INSTRUCTIONS.md#task-5-impact)
* [Task 6: Risky business](LAB6-INSTRUCTIONS.md#task-6-risky-business)

---

#### Background and Objectives

In this lab student will perform a risk analysis of their home network and online presence.

Students should become familiar with the following:

* identifying a personal inventory / attack vectors
* identify threat actors
* identify threat events
* assign impact and likeliness scores to threat events
* determine an overall risk profile of their organization

In preparation for this you should read chapters 1 and 3 of the 
[NIST 800-30](https://nvlpubs.nist.gov/nistpubs/Legacy/SP/nistspecialpublication800-30r1.pdf)
special publication.

---

#### Rubric
| Item | # Points|
| --- | --- |
| 10 commits | 10 |
| Good markdown style | 20 |
| Task 1 | 20 |
| Task 2 | 20 | 
| Task 3 | 20 |
| Task 4 | 20 |
| Task 5 | 20 |
| Task 6 | 20 |

---

#### Preparation

This lab will require all work be done on your home network.

Purpose of this assessment: to familiarize students with basic risk assessment 
vocabulary and practices, and to identify any personal high risk items in need of 
mitigation.  Since this is an initial assessment the main goal is to establish a 
baseline assessment of risk as well as identify threats, vulnerabilities, and their
likely impact on you as a student.  For the purpose of this lab, *the organization* 
is a not so fictitious **Your Name Inc.** and the primary goal of this organization is
for you to graduate.

Scope of this assessment: This assessment should apply primarily to the student
submitting this lab.  Any other users of the same network can be included as part
of this assessment.

This risk assessment should include all devices that are owned by the student and a part
of the student's home network.  It can include any other devices on the network
that you have obtained permission to include in this document.

---

### Task 1: `/home` sweet `/home`

Identify the data and resources you are protecting.  This involves three steps:

1. With permission from the network owner, scan your network with `nmap` and 
   see how many devices are on your network (do not fully scan all systems, 
   just get a count/list).  If you live on campus or anywhere else that you do NOT have permission, 
   perform the below alternate assignment.
   * Manually count all networked devices you own, and estimate the number of devices that likely share the same network 
     (assume most people on average have a similar number of devices as you do).  List ***3*** dream devices that would assist you      in completing your organizations goal of graduating.
2. Make a list of all online accounts you hold that have either a 
   credit card attached to them, or data for/about you beyond basic 
   directory information (name, email, title, general location are all directory info).  
   * If you prefer, keep this list private and provide a count of the accounts.
3. List all social media platforms you currently use.  Also, if you perfer, keep this list private and simply provide a count of the accounts ;) .
4. List any personal electronic devices that you own that may not have shown 
   up in an nmap scan.  Wearable electronics and home automation devices might be included here (bluetooth, zwave, zigbee, home automation, etc.).

With the above information gathered, answer all questions in `README.md`

---

### Task 2: Platform Inventory

Identify the following:

* 3 Software platforms in use by your "company" that are required to meet your organizations goals
  * Identify these by CPE including version info and web links via the [NVD CPE Search](https://nvd.nist.gov/products/cpe/search)
* 1 CVE that affect each of these these software platforms (ideally from this year, looking for a total of 3 CVE's)
* The top [MITRE ATT&CK](https://attack.mitre.org/) *Reconnaisance* technique that is most concerning to your organization

---

### Task 3: Guess who

Potential threat vectors incude the following:
  
* Malicious software
* Software Bugs
* Insider Threats (trusted person with or without intent to do harm)
* Outsider threats including ALL of the following:
  * Hackers
  * Crackers
  * Script Kiddie
  * Cyber Criminals
  * Cyber Terrorists
  * Hacktivists
  * State-Sponsored attackers

*** Refer to this list when it comes to answering questions in Task 3 `README.md`***

---

### Task 4: Eventually

Read through Table E-2 and E-3. Look up the following Threat Events and state their relevance
to your organization (see table E-4) and the likelihood of threat event occuring (table G-2).

Use a 0-10 scale.

#### Adversarial

* Perform perimeter network recon/scanning
* Perform network sniffing
* Craft spear phishing attack
* Exploit poorly configured or unauthorized information systems exposed to the internet
* Exploit recently discovered vulnerabilities
* Conduct simple Denial of Service attacks
* Cause integrity loss by injecting false but believable data into org info systems
* Cause unauthorized disclosure and/or unavailability by spilling sensitive information
* Obtain sensitive data/info from publicly accessible information systems
* Obfuscate adversary actions

#### Non-adversarial

* Mishandling of critical and/or sensitive information by authorized users
* Communications contention
* Unreadable display
* Natural disaster at primary facility
* Introduction of vulnerabilities into software products
* Disk error

---

### Task 5: Impact 

Measure the impact of each of the above threat events using the 0-10 scale found in 
table H-3.


---

### Task 6: Risky business

Using table I-2 assign a level of risk (0-10) based on the *Likelihood* and *Impact* 
of each threat event.

Answer all questions for tasks 3-5 in the `README.md`



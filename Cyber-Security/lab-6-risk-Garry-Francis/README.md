[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/XdKbUJhM)
# Lab 6 : CEG 3400 Intro to Cyber Security

## Name:

### Task 1: `/home` sweet `/home`

Answer the following:

* What are all CIDR's in use in your home network?

The wright state CIDR is 130.108.0.0/16 so that is the in use CIDR

* List all IP addresses that respond to a basic nmap scan [ALTERNATIVE: manually count ALL TCP/IP devices you own and mulitply by the number of people living within your building or a 500ft radius (whichever is bigger).]

I have 3 (Laptop, Phone, Switch) connected devices in my single room. There are 7 singles and 9 doubles in my wing. Assuiming everyone has 3 devices 3x7=21 6x9=54 21+54=75 so there 75 devices in my wing. There are 11 wings in the building 75x11=825 so there are around 825 connected devices in my building.

* Can you identify all devices on your network? [ALTERNATIVE: what would the CIDR need to be to house the above number of devices?]

You would need at least a CIDR of /22 with 1024 ips to house those 825 devices

* How many online accounts and social media platforms are you on
  that hold non-trivial data about you?

Accounts with NON-trivial data is about three

* How many of these are critical for your organizations business goals?

All three of those accounts are critical for my business goals.

* Do you know the Authentication policies of these critical accounts?

I know that they HAVE potential for 2FA but I don't know what kind of 2FA yet.

  * List all primary and secondary authentication methods for your most 
    important account, including non password related reset options 
    that might be vulnerable to an attacker.

    I only have the primary authentication method of my password on all three of the accounts. My
    reset options would be Email and Phone, which I suppose are both vulnerable to an attacker.

---

### Task 2: Platform Inventory

Answer the following:

* My three Platforms (CPE's) (please provide both a link and a common name/version):
  1. [cpe:2.3:a:microsoft:visual_studio_code:-:\*:\*:\*:\*:\*:\*:\*](https://nvd.nist.gov/products/cpe/detail/c3ccb025-1b28-401d-8f8b-7793691e08a5?namingformat=2.3&orderby=cpeuri&keyword=cpe%3a2.3%3aa%3amicrosoft%3avisual_studio_code%3a*%3a*%3a*%3a*%3a*%3a*%3a*%3a*&status=final)
  2. [cpe:2.3:a:microsoft:word:2016:\*:\*:\*:\*:\*:\*:\*](https://nvd.nist.gov/products/cpe/detail/7BA78764-112A-4B8A-AF41-9E09017B3D0E?namingFormat=2.3&orderBy=CPEURI&keyword=Microsoft+Word&status=FINAL) 
  3. [cpe:2.3:a:microsoft:windows_subsystem_for_linux:-:\*:\*:\*:\*:\*:\*:\*](https://nvd.nist.gov/products/cpe/detail/24C5C2CD-A282-4E77-A152-8073F9E769F7?namingFormat=2.3&orderBy=CPEURI&keyword=cpe%3A2.3%3Aa%3Amicrosoft%3Awindows_subsystem_for_linux%3A-%3A*%3A*%3A*%3A*%3A*%3A*%3A*&status=FINAL)
* Why might having the CPE lookup for your most critical software be important
  for an organization to mitigate risk?

So you can quickly identify any new CVE's that are made for that CPE

* Which CPE has the most CVE's since Jan 1, 2023?  How many?

Ubuntu has had 0 CVEs, Word has had 6 CVEs, And VSC has had 8 CVEs since the start of 2023.

* What is the highest CVSS score of any 2024 CVE related to one of your CPE's?  Link the CVE.

VSC had a CVE with a CVSS v3 score of 9.8 published on 10/8/2024 found [here.](https://nvd.nist.gov/vuln/detail/CVE-2024-43488)

* My three vulnerabilities (CVE's) (please provide both a link and a common name, a CVSS score, and a summary of each):

##### [CVE-2024-43488](https://www.cve.org/CVERecord?id=CVE-2024-43488)

Description

This is a vulnerability in the VSC Arduino extension where due to missing authentication for a critical function, allowed remote attackers to send and execute malicious code over the connected network.

##### [CVE-2024-49033](https://www.cve.org/CVERecord?id=CVE-2024-49033)

Description

This is a Microsoft Word vulnerability that because of improper input validation allowed the creation of malicious word documents that could bypass Word's security features, leading to actions like code execution or accessing sensitive information.

##### [CVE-2022-44689](https://www.cve.org/CVERecord?id=CVE-2022-44689)

Description

This is a WSL2 Ubuntu vulnerability that let local attackers give themselves higher level permissions because of improper privilege management in the WSL2 kernel. This could let an attacker get the privileges to possilby control the entire system.

#### [Search Closed Sources](https://attack.mitre.org/techniques/T1597/)

Description and writeup as to why

Searching closed sources is getting information about your victim from a source that has some exclusive factor (i.e. paid, illegal). The reason this is the most concerning to me is because there is NOTHING I can do to control this. Well realisticaly there is probably SOMETHING I could do but how would I know its working? How am I supposed to know what information about me is on the dark web short of going on the dark web? Do I have to buy my own info from a black-market just to make sure nobody else can get it?

---

### Task 3: Guess who

* List the top three threat vectors based on how likely they are to exploit your CPE/CVE's above.
  1. Insider Threats
  2. Cyber Criminals
  3. Malicious Software
* Why did you choose these three and rank them as you did?CVE-2022-44689

I put Insider Threats first because CVE-2022-44689 is a specificaly a local attack and the other two would be much easier to execute as an inside attacker. Second I put Cyber Criminals because they could preform the two network based attacks and adjust to any security in place. Third I have Malicious Software because the programs being run might not be able to adjust to every security measure in place. 

* List the top three threat vectors based on how likely they are to exploit the CWE chosen for Lab 5 (CWE-434: Unrestricted Upload of File with Dangerous Type).
  1. Malicious Software
  2. Script Kiddies
  3. Cyber Criminals
* Why did you choose these three and rank them as you did?

First is Malicious Software because there are constantly bots searching the internet for web applications with a file upload weakness. Second is Script Kiddies because the idea of a file upload attack is so understood that they can use pre-made scripts to just do the attack for them. And third is Cyber Criminals because while they can and do target file upload weaknesses, they are often skilled enough to use other methods of attack.

* List the top three threat vectors based on how likely they are to exploit your MITRE ATT&CK Recon technique above.
  1. Cyber Criminals
  2. Cyber Terrorists
  3. Hacktivists
* Why did you choose these three and rank them as you did?

I chose Cyber Criminals at number one because they're probably the people running the closed sources (the illegal ones at least) and just already have the information. Second I put Cyber Terrorists because they USUALY aren't in it for the money so they wouldn't be running the info market but would absolutely be buying. And I put Hacktivists at third because they usualy go after high profile targets like major corporations that would have information only available on these closed sources. 

---

### Task 4, 5, & 6 chart:

Please get full name of threat event from instructions.  Use the 0-10 scale 
for all likelihood, impact, and risk fields.

| **Threat Event**         | **Likelihood** | **Impact** | **Risk** |
| ---                      | ---            | ---        | ---      |
| Network recon            |        8       |      2     |     2    |
| Network Sniffing         |        3       |      5     |     3    |
| Spear Phishing           |        2       |      6     |     3    |
| Exploit IT configuration |        5       |      7     |     7    |
| Exploit new vulnerability|        8       |     10     |    10    |
| Denial of Service        |        2       |      8     |     4    |
| Integrity loss of data   |        4       |      7     |     5    |
| Unauthorized disclosure  |        2       |      0     |     1    |
| Obtain sensitive data    |        6       |      5     |     5    |
| Obfuscate actions        |        8       |      6     |     7    |
| ***non-adversarial***    | ---            | ---        | ---      |
| Mishandling data         |        3       |      8     |     7    |
| Communications contention|        5       |      3     |     4    |
| Unreadable display       |        0       |      5     |     2    |
| Natural disaster         |        1       |     10     |     2    |
| Software vulnerability   |        4       |      8     |     6    |
| Disk Error               |        7       |      7     |     7    |

---

### Task 4: Eventually

1. List one other threat event that is likely and of concern to your organization.

Obtain information by opportunistically stealing or scavenging information systems/components.

2. Why did you choose this threat event?

Because I am constantly paranoid of people taking my laptop from my bag when I leave it alone for even a minute.

3. Were there any other threat events that your organization should be concerned about?

Obtain unauthorized access: Similar to stealing components

4. What are the pros and cons of using a list of threat events such as the one included
   in the NIST 800-20 tables E-2 and E-3?

Pros:

- Standardized terminology and consistent analysis

- Faster risk assessments with a predefined baseline

- Covers both adversarial and non-adversarial threats

- Supports automation and objective scoring

- Scalable and customizable to context

Cons:

- Requires frequent updates to stay relevant

- May overlook unique or emerging threats

- Complex mapping can burden analysts

- Risk of subjective or inconsistent scoring

- Can lead to reactive, compliance-focused mindset

---

### Task 5: Impact

There are no further questions for task 4 (The task was filling in the impact collumn).

---

### Task 6: Risky business

1. Add up all numbers in your risk column and list it here:

The total is 75.

2. What threat events were hardest to determine the likelihood, and impact for? Why?

Exploit recently discovered vulnerabilities was the hardest for me to determine because it could be ANYTHING. I could be vulnerable to the method or I could not be. I ultimately decided high likelihood because if I don't know what it is I can't actively protect against it, and high impact because if I can't protect against it then I can't stop the damage.

3. What areas would you target for risk mitigation?

I would target recently discovered vulnerabilites because of previously mentioned reasons and disk error because I am working with 6.79 gigs left on my C drive and windows keeps wanting to shove more AI systems into it against my will and there is NOTHING TO DELETE.

4. What was the hardest part of this assessment (for you) and why?

The hardest part of this was writing the descriptions for the CVEs because apparently nobody who makes a CVE record can actually be bothered to write a description of what the vulnerability actually is so now I have to go looking across the entire internet to find something.

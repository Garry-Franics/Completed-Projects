# Lab 5 : CEG3400

### NIST Vulnerability Taxonomies

Table of Contents:

* [Background](#background)
* [Preparation](#preparation)
* [Task 1: CPE](#task-1---cpe)
* [Task 2: CWE](#task-2---cwe)
* [Task 3: CVE](#task-3---cve)

---

### Background

The purpose of this lab it to familiarize students with the NIST (NIST stands for National Institute of Standards and Technology) National Vulnerability Database or NVD.

The NIST NVD provides useful threat intelligence and other information to cybersecurity professionals for the purpose of speeding up the discovery, analysis, and remediations of vulnerabilities in cyberspace.

While NVD tools are typically automated to provide better vulnerability management, this lab will have you selecting a piece of software you have worked on yourself that had a vulnerability (note, many common coding and scripting mistakes lead to a vulnerability) and manually reading through some of the top Weaknesses from 2023 that lead to known vulnerabilities.

### Preparation

* Understand the interrelation of CPE, CWE, CVE, CVSS, and KEV (from lecture)

Read the following:

* [Top 25 software CWE's](https://cwe.mitre.org/top25/)
* [2024 top 10 CWE by KEV](https://cwe.mitre.org/top25/archive/2023/2023_kev_list.html)
* [Semantic Versioning 2.0.0](https://semver.org/)

---

### Task 1 - CPE

CPE stands for Common Platform Enumeration and is how we as cybersecurity experts can refer to software in a specfic manner.  Research what a [well formed CPE name](https://nvlpubs.nist.gov/nistpubs/legacy/ir/nistir7695.pdf) would look like.

Choose a piece of software you have wrote that exhibits one of the top 25 Common Weakness Enumerations from 2023 from your above research.  For this software you wrote, create a well formed CPE name for your made up vendor / software that include all relevant information to your CWE.  Make sure to include a version number in sem-ver format.

Explain all of the fields you chose to give specific information for, and all of the fields you used the wildcard character and why you did so.

---

### Task 2 - CWE

CWE stands for NIST's Common Weakness Enumeration list.  After reading the top 25 CWE's of 2023, hopefully one of them jumps out as a weakness you have put into code sometime in your academic career.

Provide a link to your chosen CWE, summarize the CWE in your words, and list some known vulnerabilities discovered using the same CWE (list them by CVE number / link and describe them briefly).

For the last part of task 2, explain what you put into code and how it relates to the CWE chosen?  Explain how your code was vulnerable to it and what impact your it might have had.

---

### Task 3 - CVE

CVE stands for Common Vulnerability and Exposure.  Task 3 has you writing a CVE for your above platform regarding the vulnerability you discovered.

Assume for the purposes of this assignment that I (Matt Kijowski) am the only CNA that can be used for this type of CVE.

The minimum data elements of a CVE are, affected products (with versions), vulnerability type and root cause (reference your CWE), impact (estimated base / overall CVSS score), and at least one public reference.

* For public reference please self refer to your github lab assignment.
* For estimate CVSS score use [a public CVSS calculator](https://nvd.nist.gov/vuln-metrics/cvss/v3-calculator)

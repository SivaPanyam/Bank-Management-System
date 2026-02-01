# Bank Management System

This repository contains the **Bank Management System** project developed in Eclipse.

This README documents:
- The project overview
- Correct Git setup for this repository
- A common Git mistake encountered and how it was fixed
- Proper steps to clear or reinitialize a GitHub repository safely

---

## Project Overview

- **Project Name:** Bank Management System  
- **Language:** Java  
- **IDE:** Eclipse  
- **Workspace:** eclipse-workspace  
- **Purpose:** Academic / learning project for banking operations

---

## Correct Project Structure

Bank-Management-System/
│── src/
│── bin/ (or target/)
│── .gitignore
│── README.md


Git should be initialized **inside this folder only**.

---

## Issue Faced (Important)

Git was accidentally initialized in a **parent directory** instead of the project folder.  
Because of this:

- Git tried to track the entire `C:\Users\sivap` directory
- System folders like `AppData`, `Documents`, `NTUSER.DAT` appeared
- Permission denied warnings occurred
- `git commit` and `git push` behaved incorrectly

---

## How the Issue Was Fixed

### 1. Identify wrong Git root
```powershell
git rev-parse --show-toplevel
This revealed that Git was tracking a parent directory.

2. Remove the wrongly initialized Git repository
Run this only at the incorrect Git root:

Remove-Item -Recurse -Force .git
This removes Git metadata only — no files are deleted.

3. Initialize Git in the correct project folder
cd eclipse-workspace\BankingSystem\Bank-Management-System
git init
git branch -M main
4. Commit the project cleanly
git add .
git commit -m "Initial commit"
5. Connect to GitHub and push
git remote add origin https://github.com/USERNAME/REPO_NAME.git
git push -u origin main

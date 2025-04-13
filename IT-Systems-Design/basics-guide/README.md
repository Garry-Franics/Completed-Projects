# Basics Guide

## Command line git

### Status
`git status [<options>] [--] [<pathspec>...]`

Shows the status of the current repository, this includes:
- Paths that have differences between the index file and the current HEAD commit.
- Paths that have differences between the working tree and the index file.
- Paths in the working tree that are not tracked by Git.

The first things that will show up are what you *will* add by running `git commit`; the rest are what you *could* commit by running `git add` before `git commit`.

[More Status](https://git-scm.com/docs/git-status)

### Log
`git log [<options>] [<revision-range>] [[--] <path>...]`

Lists commits that are reachable by following the parent links, but **not** the ones with a **^** in front of them. The output is given in reverse chronological order.

`git log foo bar ^baz` would mean "list all the commits which are reachable from foo or bar, but not from baz".

`git log origin..HEAD` and `git log HEAD ^origin` both do the same thing and can be used interchangeably.

[More Log](https://git-scm.com/docs/git-log)

### Clone
`git clone <repository> <repository> [<directory>]`

Clones a repository into a newly created directory.

The cloned repo comes with tracking branches (visible using `git branch --remotes`) and an initial branch forked from the cloned repos currently active branch.

After cloning, `git fetch` will update the remote trackers, and `git pull` will merge the remote master branch to the current master branch.

[More Clone](https://git-scm.com/docs/git-clone)

### Add
`git add [<pathspec>...]`

Updates the index with the current content in the working tree, to prepare the content for the next commit. By default it adds the current content of existing paths as a whole, but this can be modified with options.

The index holds a snapshot of the working tree, and this snapshot is taken as the contents of the next commit. Therefore you **must** add any new or modified files to the index before **every** commit.

Add can be preformed multiple times per commit, and **only** adds the specified content each time the command is run.

`git status` can be used to see what files are staged for the commit.

[More Add](https://git-scm.com/docs/git-add)

### RM
`git rm [<pathspec>...]`

Removes files from the index, or from the working tree and the index.

`git rm` will **not** remove a file from *just* your working directory, use `/bin/rm` if you want do that.

The files being removed must be identical to the tip of the branch, and no updates to their contents can be staged on the index.

To remove a file from tracking, use `git rm --cached <file>` or `git rm -r --cached <folder>`.

[More RM](https://git-scm.com/docs/git-rm)
[RM tracking](https://stackoverflow.com/questions/1274057/how-do-i-make-git-forget-about-a-file-that-was-tracked-but-is-now-in-gitignore)

### Commit
`git commit [<pathspec>]`

Creates a new commit containing the current index and a message describing the changes made to the contents.

The new commit is a direct child of HEAD and the branch, and the branch is updated to point to it.

The content to be commited can be changed in several ways:
- Using `git add` to add changes to the index.
- Using `git rm` to remove changes from the index.
- Listing files as arguments to the commit command, in which case the index will be ignored.
- Using the -a switch with the command to automatically "add" changes from all known files, and "rm" files that have been deleted.
- Using the --interactive or --patch switches to decide one by one what should be part of the commit in addition to the index.

The `--dry-run` option can be uset to obtain a summary of what is in the next commit.

A commit can be undone using `git reset`.

[More Commit](https://git-scm.com/docs/git-commit)

### Push
`git push <repository>`

Updates remote refs using local refs.

When the command does not specify where to push with the `<repository>` argument, `branch.*.remote` configuration for the current branch is consulted to determine where to push. If the configuration is missing, it defaults to origin.

[More Push](https://git-scm.com/docs/git-push)

### Fetch
`git fetch (a whole lot just check the link)`

Fetch branches and/or tags from other repos, along with the objects to complete their histories. Remote tracking branches are updated.

By default, any tag that points into the histories being fetched is also fetched. This can be changed using the --tags or --no-tags options or configuring `remote.<name>.tagOpt`. `git fetch` can fetch from either a named repo or a URL or from several repos if `<group>` is given.

When no remote is specified, the origin remote will be used

[More Fetch](https://git-scm.com/docs/git-fetch)

### Merge
`git merge`

Incorporates changes from the named commits into the current branch.

This is used by `git pull` to get changes from another repo and can be used to merge changes from one branch to another

**Do not** run a `git merge` with uncommitted changes, it could break everything.

[More Merge](https://git-scm.com/docs/git-merge)

### Pull
`git pull [<options>] [<repository> [<refspec>...]]`

Incorporates changes from a remote repo into the current branch. If the current branch is behind the remote, then it will update the branch to match the remote. If the current branch and the remote have diverged, you need to specify how to fix it with `--rebase` or `--no-rebase`.

`git pull` runs `git fetch` with the given paramaters and then will call either `git rebase` or `git merge` to reconcile diverging branches.

`<repository>` should be the name of a repo as passed to `git fetch`. `<refspec>` can name an arbitrary ref or even a collection of refs, but usualy it is the name of a branch.

Default values for `<repository>` and `<branch>` are read from the *remote* and *merge* configuration for the current branch as set by`git branch --track`.

[More Pull](https://git-scm.com/docs/git-pull)

### Branch
`git branch (even more than fetch like wow just read the link)`

If `--list` is given, or there are no non-option arguments, existing branches are listed. The current branch will be green and marked with an asterisk. Any branches checked out in linked worktrees will be cyan and maked with a plus. `-r` causes remote branches to be listed, and `-a` shows both local and remote.

This is **NOT** what you use to make a new branch. This only *lists* your current, existing branches.

[More Branch](https://git-scm.com/docs/git-branch)

### Tag
`git tag`

Add a tag reference in `refs/tags/`, unless `-d/-l/-v` is given to delete, list, or verify tags.

Unless `-f` is given, the named tag must not yet exist.

Tag objects are called "annotated" tags; they contain a creation date, name, email, tagging signature, and an optional GnuPG signature.

A "lightweight" tag is simply a name for an object (usualy a commit).

Annotated tags are meant for release while lightweight tags are meant for temporary labels. For this reason, some commands for naming objects will ignore lightweight tags by default.

[More Tag](https://git-scm.com/docs/git-tag)

### Checkout
`git checkout [<branch>]`

Updates files in the working tree to match the version in the index or the specified tree. If no pathspec was given, git will update `HEAD` to set the specified branch as the current branch

Use the command at the top to switch to an existing branch, add the option `-b` to create a new branch with the name in `[<branch>]`.

[More Checkout](https://git-scm.com/docs/git-checkout)

### INIT
`git init [<directory>]`

Creates an empty Git repository. Thats it. Like, wow, new folder.

Thats it there is nothing else.

[More INIT](https://git-scm.com/docs/git-init)

### Remote
`git remote`

Manage the repos that you are tracking.

With no arguments, shows a list of existing remotes. There are commands avalible to preform opperations on the remotes such as:
- Add: Add a remote named `<name>` for the repo at `<URL>`. The command `git fetch <name>` can be used to create and update tracking branches.
- Rename: Rename the remote named `<old>` to `<new>`. All tracking is updated.
- Remove/RM: Remove the remote named `<name>`. All trackers are removed.

[More Remote](https://git-scm.com/docs/git-remote)

## Git files & folders

### .git folder
The .git folder contains all neccesarry information relating to the functions of git such as commits, remote repo access, etc. It also contains a log that stores the commit history, letting you rollback the code if you want.

The more contents of the git folder are:
- Hooks: Git hooks are the scripts that are executed before or after events like commit, push, etc.
- Objects: An object database for git.
- Config: The local configuration file.
- Refs: Information about tags and branches.
- HEAD: Stores reference to the current branch. It points to the master branch by default.
- Index: This is a binary file and stores staging information.

The .git folder contains details of every single change made to the code. All modifications will be recorded in this folder.

[More .gitfolder](https://www.tutorialspoint.com/what-is-git-folder-and-why-is-it-hidden)

### .gitignore file
A .gitignore file is a plain text file that lists every file and folder that should not be tracked by git.

To create a .git ignore file, go to the root directory of your project and make one with vim like `vim .gitignore`.

To add a file for ignoring, just type the pwd of the file into the ignore file like `/text.txt` or `/test/text.txt`

[More .gitignore](https://www.freecodecamp.org/news/gitignore-file-how-to-ignore-files-and-folders-in-git/#introduction)

## GitHub

### Pull Requests
A pull request is a proposal to merge a set of changes from one branch to another. Colaborators can view and discuss the proposed changes before they add the changes to the main codebase.

Pull requests are created on github by clicking the "pull requests"tab at the top of a repo and then hittng "new pull request".

Once you've made a pull request, you can push commits from your branch to the pull request. These commits appear in chronological order in the pull request and changes can be seen in the "files changed" tab.

You can see information about a branch's current status on the "converstation" tab

[More Pull Request](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests)

## SSH

### SSH authentication to repositories

1. Copy the ssh url under the green code button on the repo.
2. Use `ssh-keygen -t ed25519 -C "label in here"`.
3. Copy your public key and add it to your github account's ssh keys.
4. Use `git clone [url]`.
5. You're in.

### SSH authentication to an AWS instance

1. Get the private key from AWS.
2. Place the private key inside your ubuntu.
3. Use chmod to restrict the permisions of the key so only you have read permission `chmod 600 [key]`.
4. Use `ssh -i [absolute path to key] ubuntu@[AWS instance public ip]`.
5. You're in.

### Using the config file in the .ssh folder

1. Open your `/.ssh/config` file.
2. Enter this:

Host [name of config]

User ubuntu

HostName [public ip of instance]

IdentityFile [path to private key]

Port 22

3. Use `ssh [name of config]`.
4. You're in.
# Little Cat Language (lclang)

Little Cat is a modern dynamic typed interpreted language that allows you to write programs quickly and easily.
It was influenced by Java, Kotlin, Python, PHP.
Language abbreviation `lclang`. File extension - `lcat`.

## Install

### Windows
Download the [latest release of EXE](https://github.com/lclang/LittleCat/releases/latest).

### Debian (Ubuntu and others)
```
apt update & apt install wget
wget https://github.com/lclang/LittleCat/releases/download/0.1.2/debian.deb
dpkg -i debian.deb
```

## Starting

### CLI
Open terminal and write:
```
lclang
```

Output:
![image](https://user-images.githubusercontent.com/40952805/134337779-b566f354-d822-4d03-b606-35b5e1d55ea6.png)

### File execute
```
lclang -f <relative or absolute path>
```

## Code examples

### Hello, World!
```
println(123)
```

### While loop
```
i = 0
while i <= 20: {
    println(i)
    i++
}
```

### Arrays 
```
array = [1]
array[] = 5

[a, b] = array
println(a)
println(b)
```

### HTTP client on Sockets
```
url = "info.cern.ch"
path = "/"
requestMethod = "GET"

socket = :Socket(url, 80)

output = socket.output
output.println(requestMethod+" "+path+" HTTP/1.1")
output.println("Host: " + url)
output.println("")
output.flush()

input = socket.input
while {
    if !input.hasNextLine(): return false
    println(input.readLine())
}
```

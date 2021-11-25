# Little Cat Language
[![Discord][DiscordBadge]][DiscordUrl]

Little Cat is a modern dynamic typed interpreted language that allows you to write programs quickly and easily.
It was influenced by Java, Kotlin, Python, PHP.
Language abbreviation `lclang`. File extension - `lcat`.

- [Install](https://github.com/lclang/LittleCat/blob/main/README.md#install)
    - [Windows](https://github.com/lclang/LittleCat/blob/main/README.md#windows)
    - [Debian (Ubuntu and others)](https://github.com/lclang/LittleCat/blob/main/README.md#debian-ubuntu-and-others)
- [Executing](https://github.com/lclang/LittleCat/blob/main/README.md#install)
    - [CLI](https://github.com/lclang/LittleCat/blob/main/README.md#cli)
    - [File](https://github.com/lclang/LittleCat/blob/main/README.md#file)
- [Code examples](https://github.com/lclang/LittleCat/blob/main/README.md#code-examples)


## Install

### Windows
Download the [latest release of EXE](https://ft.vitiacat.xyz/view/lclang).

### Debian (Ubuntu and others)
```
apt update & apt install wget
wget https://ft.vitiacat.xyz/download.php?id=lcdeb -O lclang.deb
dpkg -i lclang.deb
```

## Executing

### CLI
Open terminal and write:
```
lclang
```

Output:

![image](https://user-images.githubusercontent.com/40952805/134337779-b566f354-d822-4d03-b606-35b5e1d55ea6.png)

### File
```
lclang <relative or absolute path>
```

## Code examples

### Hello, World!
```
println("Hello, World!")
```

### While loop
```
i = 0
while i < 20: {
    println(i++)
}
```

OR

```
i = 0 
while { 
    println(i++) 
    return i<20
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

### Wait data from other thread
```
data = null
thread(-> {
  sleep(5000L)
  data = "New data!"
})

while data==null
println(data)
```

### HTTP client on Connection and url
```
println(readInput(
    parseUrl("https://github.com")
      .openConnection()
      .getInput()
))
```

### HTTP client on Sockets
```
url = "info.cern.ch"
path = "/"
requestMethod = "GET"

socket = :Socket(url, 80)

output = socket.getOutput()
output.println(requestMethod+" "+path+" HTTP/1.1")
output.println("Host: " + url)
output.println("")
output.flush()

println(readInput(socket.getInput()))
```

### Reflection
```
obj = :object()
obj.test = "This is string in object"

variable = reflection.getVariable(obj, "test")
println(variable.get()) // Prints: This is string in object

variable.set(123)
println(variable.get()) // Prints: 123
```

[DiscordBadge]: https://img.shields.io/discord/892491030375591977?label=Discord&logo=discord&logoColor=white

[DiscordUrl]: https://discord.gg/vBDkWUdMtx

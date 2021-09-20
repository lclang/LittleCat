# Little Cat Language (lclang)

Little Cat is a modern dynamic typed interpreted language that allows you to write programs quickly and easily.
It was influenced by Java, Kotlin, Python, PHP.
Language abbreviation `lclang`. File extension - `lcat`.

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

## Install
Download the [latest release in JAR](https://github.com/lclang/LittleCat/releases/latest).
Start jar with `java -jar app.jar`.
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText('{ "name": "John Doe", "address": {"street": "1st road", "house": 112} } /* some comment */')

assert object instanceof Map
assert object.name == 'John Doe'
println(object.address.street)
println(object.toString())      //  这个输出 [address:[house:112, street:1st road], name:John Doe]

def json = JsonOutput.toJson(object)
println(json)                   //  这个输出 {"address":{"house":112,"street":"1st road"},"name":"John Doe"}

println(json.replaceAll('"', '\\\\"'))

println("\\\", \"".replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\\\""))
println("\\")

def longString = """
asdf
asdf
asdf
"""

println longString.replace("\\", "\\\\")
System.currentTimeMillis()
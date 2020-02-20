import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText('{ "name": "John Doe", "address": {"street": "1st road", "house": 112} } /* some comment */')

assert object instanceof Map
assert object.name == 'John Doe'
println(object.address.street)
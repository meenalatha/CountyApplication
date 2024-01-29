# County Details
Establish an API layer for getting suggested counties based on provided inputs.

## Description
    Search API
    Resources for search are state and Name
    Option for attribute filtering
    API versioning support

## Partial response for Name

#### Select Single Field

	filter = "state";
	returns 
    {
        "fips": "53001",
        "state": "WA",
        "name": "Adams"
    },
    {
        "fips": "53003",
        "state": "WA",
        "name": "Asotin"
    }

#### Select Multiple Fields

	filter = "state,name"
	returns 
    {
        "fips": "53003",
        "state": "WA",
        "name": "Asotin"
    }
#### Select Fields Using Partial Name

	filter = "partialName";
	returns 
    {
        "fips": "01025",
        "state": "AL",
        "name": "Clarke"
    },
    {
        "fips": "01027",
        "state": "AL",
        "name": "Clay"
    }

#### Select Multiple Fields

	filter = "state or name"
	returns 
    {
        "fips": "53073",
        "state": "WA",
        "name": "Whatcom"
    },
    {
        "fips": "53075",
        "state": "WA",
        "name": "Whitman"
    }

#### Run with IntellijIDEA

1. Open Run/Debug configuration for your project.
2. Run the application from Run/Debug menu.
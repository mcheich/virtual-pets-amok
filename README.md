# Virtual Pets Amok

- [ ] oilAllRobots()
	
- [ ] cleanAllCages()

- [ ] emptyLitterBox()

- [ ] has interfaces for necessary functionality

- [ ] instance variable for health

- [ ] modify tick() - amount of waste in the litter box and amount of waste in an individual dog cage


## Data / Methods
* Cat - Health, Boredom, Thirst, Hunger, Waste / Play
* Dog - Health, Boredom, Thirst, Hunger, Waste / Play, Walk
* RoboCat - Health, Oil  / Play
* RoboDog - Health, Oil / Play, Walk

VirtualPetShelter Class
- [x] include appropriate instance variable(s) to store the pets who reside at the shelter
- [x] return a Collection of all of the pets in the shelter
- [x] return a specific VirtualPet given its name
- [x] allow intake of a homeless pet
- [x] allow adoption of a homeless pet
- [x] feed all of the pets in the shelter
- [x] water all of the pets in the shelter
- [x] plays (or performs some other interaction(s)) with an individual pet in the shelter
- [x] oiling/maintaining all robotic pets
- [x] cleaning dog cages
- [x] emptying the litterbox
- [x] modify existing methods to only feed/water pets that are not robotic
- [x] ~~include a tick method that calls the tick method for each of the pets in the shelter, updating their needs~~

Pet Class
- [x] name (from the above example, this might be “Tommy”)
- [x] description (from the above example, this might be “smells like a Stargazer lily fresh with morning dew”)
- [x] include a constructor that accepts a name and description
- [x] include a constructor that, in addition to name and description, accepts default values for the pet’s attributes (hunger, boredom, etc)
- [x] create a model that allows for dogs and cats, either of which may be robotic
- [x] introduce an attribute (instance variable) representing overall health that is updated as a result of other attributes moving in a negative or positive direction, influencing happiness
- [x] oiling robotic pets
- [x] walking dogs, decreasing the likelihood that organic dogs will soil their cages, while increasing happiness in all dogs
do not allow:
	feeding/watering robotic pets
	oiling organic pets
- [x] modify the tick method to return a value indicating the amount of waste a pet creates, which should contribute to either (optionally, create accessor methods to retrieve these values instead):
	- [x] amount of waste in the litter box
	- [x] amount of waste in an individual dog cage
	
VirtualPetShelterApp class
- [ ] implements a game loop.
- [ ] asks for user input.
- [ ] writes output to the console.
- [ ] calls VirtualPetShelter’s tick method after each interaction
	Available user interface actions should include (at minimum)…
- [ ] feeding all the pets
- [ ] watering all the pets
- [ ] playing with an individual pet, which should display a list of pet names and descriptions, allowing a user to select one
- [ ] allow adoption of a pet, which should display a list of pet names and descriptions, allowing a user to select one
- [ ] allow intake of a pet, prompting the user for the pet’s information, requiring the user to (at minimum) specify name and description
- [ ] walk all dogs
- [ ] clean dog cages
- [ ] clean the shelter litterbox
- [ ] oil all robotic pets

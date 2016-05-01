# singleton_jdbc_swing_3Tier

java EE example of 3 tier architecture without orm framework.
model is simple : product and category associates 0 1 / 1 n
You need to create manually the database because hibernate/jpa is not used.Refer to associations used in model and interface implementation.

Singleton pattern in dao class.
An interface with crud methods implemented in business layer . orm is written totally (mapping).
View layer uses swing java api. Listener in catalogue_swing2 (external) or internal catalogue_swing (change in main call the class wanted)
Test class is present.

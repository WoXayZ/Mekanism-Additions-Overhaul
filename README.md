# Mekanism Additions Overhaul

Baby variants for Creeper Overhaul and Enderman Overhaul, plus vanilla baby spiders.
Minecraft **1.20.1** / **Forge 47.4.0**. Version **1.0.0**.

Each adult variant gets a baby. The baby reuses the adult geo, Java model and texture, and renders smaller. Nothing in this jar is a new png or a new geo.

---

## What it adds

**Creeper Overhaul 3.0.2.** One baby entity per egg variant that exists on 1.20.1: badlands, bamboo, beach, cave, dark oak, desert, dripstone, hills, jungle, mushroom, ocean, savannah, snowy, spruce, swamp. Birch is not in this Creeper Overhaul release. Ocean keeps the adult's ocean_1 / ocean_2 / ocean_3 choice. Desert and badlands keep the sheared geo when the adult can be sheared. `mekanismadditions:baby_creeper` is rendered with the plains geo and texture. There is no second plains baby.

**Enderman Overhaul 1.0.4.** One baby per hostile biome enderman, plus Flower Fields and Mushroom Fields, which stay passive. `mekanismadditions:baby_enderman` is rendered with the default Enderman Overhaul geo and texture. Enderman Overhaul 1.0.4 does not do that replacement itself.

**Spiders.** A baby spider and a baby cave spider, poison included. Spider Overhaul has no 1.20.1 release, so the biome variants are not in this branch.

Babies do not grow and do not breed. Hitbox, health, speed and attack use the Mekanism Additions baby factors from 1.21 (there is no shared modifier helper on 1.20.1). Creeper explosion radius is 1.5, or 3 when charged. Spawn is a separate biome entry at 5% of the adult weight. Each baby has a spawn egg, a creative tab, and a reduced loot table.

---

## Requirements

| Dependency | Required | Version |
| --- | --- | --- |
| Minecraft | yes | 1.20.1 |
| Forge | yes | 47.4.0 |
| Java | yes | 17 |
| Mekanism | yes | 1.20.1-10.4.16.80 |
| Mekanism Additions | yes | 1.20.1-10.4.16.80 |
| [Creeper Overhaul](https://www.curseforge.com/minecraft/mc-mods/creeper-overhaul) | no | 3.0.2 |
| [Enderman Overhaul](https://www.curseforge.com/minecraft/mc-mods/enderman-overhaul) | no | 1.0.4 |
| GeckoLib | with creeper or enderman | 4.7.2 |

Creeper Overhaul also needs Resourceful Config. Enderman Overhaul also needs Resourceful Lib and Resourceful Config. A missing Overhaul does not stop the game.

---

## Configuration

`config/mekanismadditionsoverhaul-common.toml`. One section per baby:

```toml
[baby_jungle_creeper]
	#Spawn this baby in biomes where the adult already spawns.
	enabled = true
	#Fraction of the adult spawn weight. 0.05 is the Mekanism baby default.
	#Range: 0.0 ~ 100.0
	weight = 0.05
```

---

## Building

```bash
./gradlew jar
```

On Windows: `gradlew.bat jar`.

The jar lands in `build/libs/mekanismadditionsoverhaul-1.20.1-1.0.jar`.

```bash
./gradlew runClient
```

`runClient` loads Mekanism, Mekanism Additions, GeckoLib, Resourceful Lib, Resourceful Config, JEI, Creeper Overhaul and Enderman Overhaul from the local instance jars, remapped onto the dev classpath. `run/mods` stays empty so those production jars are not loaded a second time.

## License

MIT.

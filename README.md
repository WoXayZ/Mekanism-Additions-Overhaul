# Mekanism Additions Overhaul

Baby variants for Creeper Overhaul, Enderman Overhaul and Spider Overhaul.
Minecraft **1.21.1** / **NeoForge 21.1.259**. Version **1.0.0**.

Each adult variant gets a baby. The baby reuses the adult geo, Java model and texture, and renders smaller. Nothing in this jar is a new png or a new geo.

---

## What it adds

**Creeper Overhaul.** One baby entity per egg variant: badlands, bamboo, beach, birch, cave, dark oak, desert, dripstone, hills, jungle, mushroom, ocean, savannah, snowy, spruce, swamp. Ocean keeps the adult's ocean_1 / ocean_2 / ocean_3 choice. Desert and badlands keep the sheared geo when the adult can be sheared. `mekanismadditions:baby_creeper` is rendered with the plains geo and texture. There is no second plains baby.

**Enderman Overhaul.** One baby per hostile biome enderman, plus Flower Fields and Mushroom Fields, which stay passive. `mekanismadditions:baby_enderman` keeps the renderer Enderman Overhaul already registers for it.

**Spider Overhaul.** A baby spider, a baby cave spider (poison included), and one baby per variant: birch, cavern, desert, ice, jungle, mushroom, ocean, savanna, sculk, swamp, taiga. Cavern babies follow `CavernSpiderType`. The ocean baby is the crab. Renderers bake the adult model layer, including the vanilla-style alternate, and scale the pose.

Babies do not grow and do not breed. Hitbox, health, speed and attack use the same scale Mekanism Additions uses for its own babies. Creeper explosion radius is 1.5, or 3 when charged. Spawn is a separate biome entry at 5% of the adult weight. Each baby has a spawn egg, a creative tab, and a reduced loot table.

---

## Requirements

| Dependency | Required | Version |
| --- | --- | --- |
| Minecraft | yes | 1.21.1 |
| NeoForge | yes | 21.1.259 |
| Java | yes | 21 |
| Mekanism | yes | 1.21.1-10.7.19.85 |
| Mekanism Additions | yes | 1.21.1-10.7.19.85 |
| [Creeper Overhaul](https://www.curseforge.com/minecraft/mc-mods/creeper-overhaul) | no | 4.0.6 |
| [Enderman Overhaul](https://www.curseforge.com/minecraft/mc-mods/enderman-overhaul) | no | 2.0.3 |
| [Spider Overhaul](https://www.curseforge.com/minecraft/mc-mods/spider-overhaul) | no | 0.0.6 |
| GeckoLib | with creeper or enderman | 4.9.3 |

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

The jar lands in `build/libs/mekanismadditionsoverhaul-1.21.1-1.0.jar`.

```bash
./gradlew runClient
```

`runClient` loads Mekanism, Mekanism Additions, GeckoLib, Resourceful Lib, Resourceful Config, Cloth Config, JEI, and the three Overhaul jars from the Expandia Arcane & Alloy instance.

## License

MIT.

# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).
Prior to version 2.0.0, this project used MCVERSION-MAJORMOD.MAJORAPI.MINOR.PATCH.

## [2.0.0-alpha.1+1.16.5] - 2022.07.04
### Changed
- Updated to Minecraft 1.16.5
- Updated to Forge 36+
- Updated to Tinkers' Construct 3+
- Armor and materials have been updated to conform to the new Tinkers' 3.0 system, which includes:
  - Armor comes with their own array of slots: 1 upgrade, 2 defense, and 1 ability
  - Materials have been removed and added according to what is available from base Tinkers' Construct
    - Certain materials, such as String, are not available on armor while other materials, such as Leather, have extended
      use on armor compared to tools
- Armor is now made with only two parts: Plate and Mail
  - Plate stats include: Durability, Armor, Toughness, Knockback Resistance, and Movement Speed Bonus
  - Mail stats include: Durability Modifier, Armor Modifier, and Movement Speed Bonus Modifier
- Traits have all been changed and retooled to fit the new design
### Removed
- Removed Armor Station and Armor Forge, armor is now created in the Tinker Station and Tinker's Anvil along with the
  Tinkers' tools
- Removed Armory Addendum book - in-game documentation will return in a future update

## [1.12.2-1.2.5.10] - 2021.01.19
### Fixed
- Fixed Korean translation errors (thanks SnowBlack!)
- Fixed texture loading errors with TexFix [#207](https://github.com/TheIllusiveC4/ConstructsArmory/issues/207)
- Fixed ContentTweaker onDamaged function [#249](https://github.com/TheIllusiveC4/ConstructsArmory/issues/249)

## [1.12.2-1.2.5.9] - 2020.05.21
### Fixed
- Fixed IllegalCacheLoadException when rendering textures [#226](https://github.com/TheIllusiveC4/ConstructsArmory/issues/226)

## [1.12.2-1.2.5.8] - 2020.05.03
### Changed
- Changed Polishing modifier to original behavior that overrides toughness [#223](https://github.com/TheIllusiveC4/ConstructsArmory/issues/223)

## [1.12.2-1.2.5.7] - 2020.05.02
### Fixed
- Fix accessory rendering issues while sneaking

## [1.12.2-1.2.5.6] - 2020.04.30
### Fixed
- Fix armor accessories not rendering on armor stands

## [1.12.2-1.2.5.5] - 2020.04.27
### Fixed
- Fix CraftTweaker integration Knockback event handler [#222](https://github.com/TheIllusiveC4/ConstructsArmory/issues/222)
- Fix armor texture reloading [#221](https://github.com/TheIllusiveC4/ConstructsArmory/issues/221)

## [1.12.2-1.2.5.4] - 2020.02.16
### Fixed
- Fix Alien growth potential being stunted by 25% [#208](https://github.com/TheIllusiveC4/ConstructsArmory/issues/208)
- Fix preview panel cape rendering [#202](https://github.com/TheIllusiveC4/ConstructsArmory/issues/202)

## [1.12.2-1.2.5.3] - 2019.11.03
### Fixed
- Fix all blocks giving XP [#196](https://github.com/TheIllusiveC4/ConstructsArmory/issues/196)

## [1.12.2-1.2.5.2] - 2019.11.03
### Changed
- Ambitious trait behavior changed to avoid potential exploits, it will now provide extra XP when killing mobs and breaking blocks rather than increasing XP on pickup [#172](https://github.com/TheIllusiveC4/ConstructsArmory/issues/172)
### Fixed
- Fix Dramatic trait not accounting for protected damage [#177](https://github.com/TheIllusiveC4/ConstructsArmory/issues/177)
- Fix ArmorModifications not being exposed to CraftTweaker [#175](https://github.com/TheIllusiveC4/ConstructsArmory/issues/175)
- Fix ContentTweaker armor traits not being able to be added to items [#194](https://github.com/TheIllusiveC4/ConstructsArmory/issues/194)

## [1.12.2-1.2.5.1] - 2019.10.27
### Fixed
- Fixed Autoforge trait not repairing when under the effects of Fire Resistance [#193](https://github.com/TheIllusiveC4/ConstructsArmory/issues/193)
- Fixed Dramatic trait not preventing fatal damage [#177](https://github.com/TheIllusiveC4/ConstructsArmory/issues/177)

## [1.12.2-1.2.5.0] - 2019.10.14
### Added
- Added XP leveling configs, XP Gain Cap and Damage to XP Multiplier [#176](https://github.com/TheIllusiveC4/ConstructsArmory/issues/176)
### Fixed
- Fixed NoSuchFieldError with Tinkers' 2.13.0.171 [#178](https://github.com/TheIllusiveC4/ConstructsArmory/issues/178)

## [1.12.2-1.2.4.0] - 2019.05.31
### Changed
- Aquaspeed trait can now provide faster sinking speed when players sneak while swimming [#169](https://github.com/TheIllusiveC4/ConstructsArmory/issues/169)
- Updated Chinese localization (thank you mcBegins2Snow)
- Updated Brazilian localization (thank you SAMUELPV)
### Fixed
- Fixed Steady trait causing erroneous knockbacks on entities with knockback resistance

## [1.12.2-1.2.3.4] - 2019.04.21
### Fixed
- Fixed armor model texture scaling [#160](https://github.com/TheIllusiveC4/ConstructsArmory/issues/160)

## [1.12.2-1.2.3.3] - 2019.04.18
### Changed
- Combustive, Rough, and Spiny traits now do knockback on targets [#158](https://github.com/TheIllusiveC4/ConstructsArmory/issues/158)

## [1.12.2-1.2.3.2] - 2019.04.16
### Changed
- Updated Chinese localization (thank you mcBegins2Snow)
### Fixed
- Fix damage reduction not being capped to 80% [#154](https://github.com/TheIllusiveC4/ConstructsArmory/issues/154)
- Fix missing localizations [#153](https://github.com/TheIllusiveC4/ConstructsArmory/issues/153) [#155](https://github.com/TheIllusiveC4/ConstructsArmory/issues/155)

## [1.12.2-1.2.3.1] - 2019.04.11
### Changed
- Frosty modifier is now incompatible with Autoforge trait due to ability contradictions [#151](https://github.com/TheIllusiveC4/ConstructsArmory/issues/151)

## [1.12.2-1.2.3] - 2019.01.15
### Changed
- Armor core textures now look less like vanilla armor [#142](https://github.com/TheIllusiveC4/ConstructsArmory/issues/142)

## [1.12.2-1.2.2.0] - 2019.01.02
### Added
- Information in the book about how to start crafting armor parts

## [1.12.2-1.2.1.1] - 2018.12.27
### Fixed
- Binary compatibility with ContentTweaker integration [#137](https://github.com/TheIllusiveC4/ConstructsArmory/issues/137)

## [1.12.2-1.2.1.0] - 2018.12.23
### Added
- Broken rendering for armor now have their own textures [#109](https://github.com/TheIllusiveC4/ConstructsArmory/issues/109)
### Fixed
- Resistant modifiers miscalculating damage when wearer has Absorption health [#133](https://github.com/TheIllusiveC4/ConstructsArmory/issues/133)
- Armor rendering when worn by Zombies and Skeletons [#99](https://github.com/TheIllusiveC4/ConstructsArmory/issues/99)
- Goggles rendering lower than intended when sneaking


## [1.12.2-1.2.0.2] - 2018.11.29
### Added
- Korean localization (thanks hatik05)
### Fixed
- Miscellaneous repair bugs [#135](https://github.com/TheIllusiveC4/ConstructsArmory/issues/135)

## [1.12.2-1.2.0.1] - 2018.10.25
### Fixed
- Invigorating trait healing bug [#126](https://github.com/TheIllusiveC4/ConstructsArmory/issues/126)
- ContentTweaker modifier items not registering correctly [#127](https://github.com/TheIllusiveC4/ConstructsArmory/issues/127)

## [1.12.2-1.2.0.0] - 2018.10.13
### Added
- [API] Slot-less damageArmor method, deprecated old method
- Biomes O' Plenty Lilypad support for the Frosty modifier
### Changed
- Frosty modifier now requires a new item, Frosty Soles, which is comprised of the old recipe
### Fixed
- Invigorating trait data bug [#123](https://github.com/TheIllusiveC4/ConstructsArmory/issues/123)

## [1.12.2-1.1.2.0] - 2018.09.30
### Added
- [API] Javadocs to IArmorTrait.class and IArmorAbility.class
- Extra info for Amphibious modifier to display stored oxygen in Armor Station/Forge [#116](https://github.com/TheIllusiveC4/ConstructsArmory/issues/116)
- Portuguese translation (thank you SAMUELPV)
### Fixed
- Invigorating trait healing bug [#118](https://github.com/TheIllusiveC4/ConstructsArmory/issues/118)
### Removed
- Speed FoV config option (split into separate mod, [Custom FoV](https://minecraft.curseforge.com/projects/custom-fov))

## [1.12.2-1.1.1.1] - 2018.09.05
### Added
- Config option to control max speed FoV changes [#98](https://github.com/TheIllusiveC4/ConstructsArmory/issues/98)
### Fixed
- ContentTweaker integration [#107](https://github.com/TheIllusiveC4/ConstructsArmory/issues/107)
- NPE in ArmorModifiers::getItems [#106](https://github.com/TheIllusiveC4/ConstructsArmory/issues/106)

## [1.12.2-1.1.0.0] - 2018.08.28
### Added
- Concealed modifier from new Invisible Ink item, makes armor invisible (purely cosmetic) [#64](https://github.com/TheIllusiveC4/ConstructsArmory/issues/64)
- (API) Added disableRendering method for additional invisibility logic
### Changed
- Updated Forge dependency to 14.23.4.2745
- Aquaspeed trait now uses the new Forge attribute for Swim Speed (thank you Karthas077) [#101](https://github.com/TheIllusiveC4/ConstructsArmory/issues/101)
- Updated ContentTweaker dependency to 4.8.0
- Updated ContentTweaker integration [#100](https://github.com/TheIllusiveC4/ConstructsArmory/issues/100)
- (API) Split onArmorChanged into onArmorEquipped and onArmorRemoved
- Traveller's Cloak of Invisibility, when active, now makes the chestplate invisible as well
### Fixed
- Invigorating hearts not persisting upon relogging [#103](https://github.com/TheIllusiveC4/ConstructsArmory/issues/103)

## [1.12.2-1.0.2.0] - 2018.07.19
### Added
- Player Heal trait event
### Changed
- Parasitic trait adds exhaustion in exchange for durability repair instead of damaging the player [#76](https://github.com/TheIllusiveC4/ConstructsArmory/issues/76)
- Invisibility Cloak is more powerful (weaker than potion Invisibility when wearing 1 or less piece of armor, but becomes more powerful by comparison with more armor)
### Fixed
- CraftTweaker setToughness method applying to the modifier rather than toughness value
- Calcic trait activating for all food items rather than just milk [#86](https://github.com/TheIllusiveC4/ConstructsArmory/issues/86)
- High Stride modifier letting sneaking players fall off blocks [#82](https://github.com/TheIllusiveC4/ConstructsArmory/issues/82)
- Invisibility Cloak book entry [#85](https://github.com/TheIllusiveC4/ConstructsArmory/issues/85)

## [1.12.2-1.0.1.2] - 2018.06.30
### Fixed
- Polished modifier overwriting toughness values [#77](https://github.com/TheIllusiveC4/ConstructsArmory/issues/77)
- Combustible trait setting fire to entities that are immune to fire
- JEI not interpreting Armor Forge subtypes correctly [#71](https://github.com/TheIllusiveC4/ConstructsArmory/issues/71)
- Armor models clipping on some player skins
- Crashing on outdated Forge versions by updating the dependency version
- Crashing with ArrayIndexOutOfBoundsException with Blood Magic's Living Armor [#75](https://github.com/TheIllusiveC4/ConstructsArmory/issues/75)

## [1.12.2-1.0.1.1] - 2018.06.26
### Fixed
- Crash when loading with CraftTweaker without ContentTweaker [#71](https://github.com/TheIllusiveC4/ConstructsArmory/issues/71)

## [1.12.2-1.0.1.0] - 2018.06.26
### Added
- Turkish translation (thank you atlj_)
- Russian translation (thank you vizmarios)
- ContentTweaker integration (please refer to the GitHub wiki for documentation)
### Fixed
- High Stride modifier not being restricted to boots [#67](https://github.com/TheIllusiveC4/ConstructsArmory/issues/67)
- Armor Defense reduction being way too much

## [1.12.2-1.0.0.0] - 2018.06.15
### Added
- GPL license file to accompany the LGPL license
- Config option for Bouncy trait durability usage
### Changed
- Updated zh_cn.lang (thank you DYColdWind)
- Leveling now ignores all unblockable damage
- Deprecated usage of registerTileEntity now uses the updated method
### Fixed
- Crashes when adding potion effects from the Vengeful trait to FakePlayer entities [#63](https://github.com/TheIllusiveC4/ConstructsArmory/issues/63)
### Removed
- Boots accessory keybinding since it's currently unused

## [1.12.2-0.0.0.23-rc3] - 2018.06.12
### Changed
- License for Construct's Armory changed from GPLv3 to LGPLv3
- Updated Tinkers' Construct dependency to 1.12.2-2.10.1.87
- Modifier model texture code now determined by modifier rather than armor, this should be the correct abstraction to allow for add-on modifiers to show up correctly but I really have no idea so if you're an add-on developer and you want to add a modifier and nothing works for you as is, contact me please.

## [1.12.2-0.0.0.22-rc2] - 2018.06.11
### Fixed
- Autoforge trait not repairing armor on fire [#57](https://github.com/TheIllusiveC4/ConstructsArmory/issues/57)
- Armor taking double durability damage
- NoSuchMethodError crash with Tinkers' Construct 1.12.2-2.10.1.87 [#60](https://github.com/TheIllusiveC4/ConstructsArmory/issues/60)

## [1.12.2-0.0.0.21-rc1] - 2018.06.06
### Added
- Spawn With Book config option - Set to true to give armory book on first spawn
- Compact GUI config option - Set to true to remove the armor preview [#47](https://github.com/TheIllusiveC4/ConstructsArmory/issues/47)
- Leveling config options - Basically a separate config from the base tool leveling config to modify the armor leveling stuff
### Changed
- Mending modifier can now repair anywhere in the inventory
- Petravidity trait no longer absorbs stone to heal, instead it makes armor more effective around stone blocks
- Bouncy trait on boots now damages the armor on every bounce
### Fixed
- Fixed High Stride step assist becoming permanent [#54](https://github.com/TheIllusiveC4/ConstructsArmory/issues/54)

## [1.12.2-0.0.0.20-beta] - 2018.06.02
### Added
- Traveller's Goggles (Soul Sight) accessory - Allows the wearer to see nearby souls
- Traveller's Cloak (Invisibility) accessory - Allows the wearer to turn invisible
- Traveller's Cloak (Slow Fall) accessory - Slows falling on the wearer and negates fall damage
- Traveller's Belt (Alchemy) accessory - Allows the wearer to store potions that can stack up to 4 times
- Powerful modifier - Only on chestplates - Increases attack damage
- Dexterous modifier - Only on chestplates - Increases attack speed
- Telekinetic modifier - Only on chestplates - Increases reach distance
- Glowing modifier - Only on boots - Uses durability to light up dark spots under you
- New op command, /levelupArmor, for debugging leveling integration
### Changed
- Can now close the respective GUIs of accessories with the toggle keybind
- Updated Chinese localization (thanks to DYColdWind)
- Buffed Lightweight trait speed bonus
- Changed accessory tooltip, now shows toggle status for applicable accessories
- Void damage no longer gives armor XP
### Fixed
- High Stride modifier not appearing in the in-game book
- Armor XP breaking when hit by extremely high damage values (i.e. /kill)

## [1.12.2-0.0.0.19-beta] - 2018.05.22
### Fixed
- Crashing when taking damage from Guardians while wearing Rough armor [#43](https://github.com/TheIllusiveC4/ConstructsArmory/issues/43)

## [1.12.2-0.0.0.18-beta] - 2018.05.21
### Added
- German translation (thanks to ACGaming)
- Traveller's Goggles (Night Vision) accessory - Grants you night vision at the cost of durability
- Sticky modifier - Slows down attackers
- Shulkerweight modifier - Grants jump boost, but no fall protection
- High Stride modifier - Only on boots - Grants step assist
### Changed
- Traveller's Goggles zooms less and smoother [#42](https://github.com/TheIllusiveC4/ConstructsArmory/issues/42)
- Shielding trait works on more magical attacks
### Fixed
- Creative modifier not working on armor pieces [#39](https://github.com/TheIllusiveC4/ConstructsArmory/issues/39)
- Calcic trait not working in Survival [#37](https://github.com/TheIllusiveC4/ConstructsArmory/issues/37)
- Various GUI problems [#38](https://github.com/TheIllusiveC4/ConstructsArmory/issues/38) [#41](https://github.com/TheIllusiveC4/ConstructsArmory/issues/41)

## [1.12.2-0.0.0.17-beta] - 2018.05.18
### Added
- Tinkers' Tool Leveling integration
### Changed
- Increased level of Magnetic trait on Iron core parts to II
- Increased level of Mundane trait on Flint core parts to II
- Gave Shielding trait back to other Lead parts
- Updated book contents

## [1.12.2-0.0.0.16-alpha] - 2018.05.16
### Added
- Featherweight trait - Reduces fall damage
- Amphibious trait - Helmets only - Extends underwater breathing time 
- Frosty trait - Boots only - Freezes nearby water blocks
- New materials for all Resistant modifiers
### Changed
- Replaced Lightweight trait on Cobalt cores with Featherweight trait
- Lightweight trait movement speed bonus has been significantly reduced
- Modifiers once again use regular crafting materials instead of armor kits
- Speedy trait now has 3 levels, with less movement speed per level and a lower cost
- Resistant traits no longer give Protection enchantments, they use internal calculations instead now
- Resistant traits now have 8 levels, with the same total damage reduction potential and a different cost
- Changed some of the wording in the book for some modifiers
- Lowered the required modifiers for accessories from 2 to 1
- Armor Station (not Armor Forge!) now allows you to mix materials and replace parts, but no longer can apply modifiers
### Fixed
- Reinforced modifier not appearing on armor models
- Unrelated items appearing in the armor preview panels
- Armor result disappearing when crafting in the GUI [#30](https://github.com/TheIllusiveC4/ConstructsArmory/issues/30)
- Armor renaming not working properly
### Removed
- Armor kits
        
## [1.12.2-0.0.0.15-alpha] - 2018.05.13
### Added
- Armor preview to the GUI for Armor Forge and Armor Station
### Changed
- Miscellaneous code cleanup
- Separated accessories and modifiers in the in-game book
### Fixed
- Error related to the Embossment model loader
- Armor page in the in-game book

## [1.12.2-0.0.0.14-alpha] - 2018.05.11
### Added
- Textures for all modifiers, for both the item and the armor models
- Bouncy trait to Slime and Blue Slime, increases knockback on the wearer and acts as Slime Boots for boots
- Embossment modifier to the in-game book
### Changed
- Dramatic trait now behaves as such: 10% chance to nullify damage and heal you a little bit per armor piece when taking fatal damage
- Indomitable trait no longer caps Defense to 20
- Magnetic trait no longer affects items recently dropped by players
- Prideful trait now behaves as such: If a player has been attacked in the last 2 seconds, increase armor effectiveness by 10% per armor piece at the cost of durability.
- Prideful trait and Vengeful trait have switched armor pieces (Prideful is on Plates and Trim, Vengeful is on Core)
- Changed Steady trait calculations, knockback on attackers is increased
- Shielding trait for Lead is now only on the Core piece
### Fixed
- Polished modifier not working

## [1.12.2-0.0.0.13-alpha] - 2018.04.23
### Fixed
- Crash on dedicated server boot

## [1.12.2-0.0.0.12-alpha] - 2018.04.23
### Added
- Paper and cactus armor textures for items and models, this should complete all of the material armor textures
- Traveller's Gear now have textures on the armor items
- Traveller's Gear now renders on the player when wearing an armor attached with them
    - Note: Traveller's Gear updates may require you to remake your armor to correctly appear
### Changed
- Tweaked cost of armor parts, armor plates are much less costly while helmet cores and boots cores cost a little more
- Broken armor no longer renders when worn by players
- Tooltip now says "Accessory: ___" to indicate accessory attachments on armor
### Fixed
- Armor clipping some player's skins (hopefully it's scaled up enough to prevent most cases)
- Crashing when using Manyullyn armor's Prideful trait
- Armor applying defense values and traits even when the armor is broken
- Fractional armor values not displaying and calculating correctly

## [1.12.2-0.0.0.11-alpha] - 2018.04.12
### Added
- Flint and obsidian textures for both the armor items and models
### Changed
- Armor values for materials have been flattened into a single "defense" stat. This stat represents the combined total armor value of a suit of armor made out of that material. For instance, iron level armor would have a defense value of 15. This change was made to make it easier for both me and players to compare material stats at a glance.
- Rebalanced all of the armor stats once again. Armor defense values do not go above Diamond, and toughness values do not go above 5. Also made sure that toughness values do not appear too high on early to mid-game materials.
- Refactored armor and toughness to use attributes again, this should also fix problems with certain GUI mods not catching the toughness levels of the armor.

## [1.12.2-0.0.0.10-alpha] - 2018.04.03
### Added
- Armor Station - an early-game version of the Armor Forge. It can create the same armor types as the Armor Forge, the limitation is that all of the materials have to match each other (and thus armor part swapping cannot be done either). It can still perform all the modifications that the Armor Forge can.
- Chinese localization courtesy of DYColdWind
### Changed
- Armor Forge recipe has been changed to accommodate the addition of the armor station
- Armor Forge texture has been updated
### Fixed
- Traveller's Knapsack and Traveller's Belt deleting their inventories upon modifying the armor they're attached to

## [1.12.2-0.0.0.9-alpha] - 2018.03.25
### Added
- Armor part swapping - works the same way as tools, just place the armor part you want to swap with into the Armor Forge alongside the armor piece
- Armor embossment - works the same way as tools, use the Slime Crystals and a Gold Block in addition to the armor part you want to emboss. Not in the book yet, but it should work all the same.
- Modifier models - Speedy, Diamond, and Emerald modifiers now have graphical changes to the item and armor models. These textures are subject to change, I just needed them to test the functionality.
### Changed
- Adjusted armor toughness calculations to more closely mimic vanilla mechanics
### Fixed
- Potential issues with armor abilities staying on the player after removing armor

## [1.12.2-0.0.0.8-alpha] - 2018.03.09
### Added
- Creative modifier - Works the same as the TCon creative modifier, even uses the same material
### Changed
- Modifiers mostly no longer use raw materials, instead they use special "Armor Kits" that are crafted. This change was made for a few reasons, but mainly to avoid conflict with using the same materials as other TCon modifiers.
- Following the previous change, changes have been made to the maximum values for the Speedy and Resistant(s) modifiers. Everything considered, they are fairly more expensive now. Also, this could cause some funky behavior for your already modified armor so just remake it if that happens.
- Updated some textures.
### Fixed
- Certain TCon modifiers being unavailable due to material conflicts
- End armor being listed multiple times in JEI
        
## [1.12.2-0.0.7.1-alpha] - 2018.03.02
### Fixed
- Server crash due to client-side coding

## [1.12.2-0.0.0.7-alpha] - 2018.03.01
### Added
- Traveller's Gear! (well, some of them, and kinda)
    - These are part of a new sub-category of modifiers called "accessories". Accessories are exclusive to a certain body part, each armor piece can only hold one accessory, they have abilities that are tied to a keybinding, and they take up 2 modifiers.
    - Traveller's Belt - Can swap your hotbar with a secondary hotbar stored inside the belt
    - Traveller's Goggles - Can zoom into faraway places
    - Traveller's Knapsack - Can store an extra 27 slots of items
- CraftTweaker support for changing material stats (documentation forthcoming)
### Changed
- Changed almost all of armor and toughness material stats. This was done to help balance the armor alongside vanilla values.
    - Armor values are now more average. The weaker armor have been made stronger and the stronger armor have been made weaker.
    - Toughness is less common on materials, but materials that do have it generally have more toughness than before.
- Changed a lot of the internal names for modifiers/traits. This was done to fix current compatibility issues with other mods that add modifiers/traits with the same name, and to prevent future issues from occurring. This will cause all current armor to lose most of their traits/modifiers.
### Fixed
- Small memory leak issue with the dynamic textures

## [1.12.2-0.0.0.6-alpha] - 2018.02.26
### Added
- Polished modifier - works like the TCon Fortify/Sharpening Kit (instead of increasing mining level, it increases toughness)
### Changed
- Complete rendering refactor, minimal to no FPS drops now when rendering the armor. This also fixes some small, weird graphical glitches that happen with the armor sometimes.
### Fixed
- Armor modifiers being called the original TCon modifier name in the in-game book

## [1.12.2-0.0.0.5-alpha] - 2018.02.24
### Added
- Soulbound modifier
### Changed
- Updated Tinkers' Construct dependency to 2.9.1 and up
### Fixed
- Tool modifiers being replaced by their armor modifier equivalent (applies to Parasitic/Necrotic, Emerald, Mending Moss, maybe more. Best idea is to just remake your tools if you're using this mod.)
- Armor models rendering oddly on armor stands

## [1.12.2-0.0.0.4-alpha] - 2018.02.21
### Added
- Mending modifier - works like the original TCon one, requires you to not be wearing the armor to repair itself
### Changed
- Emerald modifier now also raises an armor piece's defense points to 2 if it is lower than that
- Ecological trait now works even if you're not wearing the armor, but received a slight nerf to its recovery speed in exchange
### Fixed
- Crashing when loaded with FTBUtilities

## [1.12.2-0.0.0.3-alpha] - 2018.02.19
### Added
- Speedy modifier - Adds movement speed
- Resistant modifier - Adds Protection
- Fire Resistant modifier - Adds Fire Protection
- Blast Resistant modifier - Adds Blast Protection
- Projectile Resistant modifier Adds Projectile Protection
- Parasitic modifier - Steals your life to repair itself (doesn't kill you)
- Reinforced modifier - Same as regular Reinforced from Tinkers'
- Diamond modifier - Adds durability and stats
- Emerald modifier - Adds durability
### Fixed
- Core and plate material stats being switched when crafting the armor (you'll need to remake any for the proper stats)

## [1.12.2-0.0.0.2-alpha] - 2018.02.18
### Fixed
- Potential crashes with the unused modifier code
    
## [1.12.2-0.0.0.1-alpha] - 2018.02.18
- Initial release
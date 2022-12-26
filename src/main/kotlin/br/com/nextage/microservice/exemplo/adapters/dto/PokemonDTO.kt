package br.com.nextage.microservice.exemplo.adapters.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonDTO(
        var id: Long? = null,
        var name: String? = null,
        @field:JsonProperty(value = "is_default")
        var is_default: Boolean? = null,
        var order: Int? = null,
        var base_experience: Int? = null,
        var height: Double? = null,
        var weight: Double? = null,
        var location_area_encounters: String? = null,
        var types: List<TypesDTO>? = null,
        var abilities: List<AbilitiesDTO>? = null,
        var forms: List<FormsDTO>? = null,
        var game_indices: List<GameIndicesDTO>? = null,
        var stats: List<StatsDTO>? = null,
        var moves: List<MovesDTO>? = null,
        var sprites: SpritesDTO? = null,
        var species: SpeciesDTO? = null,
        var held_items: List<HeldItemsDTO>? = null
)

data class TypesDTO(
    var slot: Int? = null,
    var type: TypeDTO? = null
)

data class TypeDTO(
    var name: String? = null,
    var url: String? = null
    )

data class AbilitiesDTO(
    var ability: AbilityDTO? = null,
    @field:JsonProperty(value = "is_hidden")
    var is_hidden: Boolean? = null,
    var slot: Int? = null
)

data class AbilityDTO(
    var name: String? = null,
    var url: String? = null
)

data class FormsDTO(
    var name: String? = null,
    var url: String? = null
)

data class GameIndicesDTO(
    var game_index: Int? = null,
    var version: VersionDTO? = null
)

data class VersionDTO(
    var name: String? = null,
    var url: String? = null
)

data class StatsDTO(
    var base_stat: Int? = null,
    var effort: Int? = null,
    var stat: StatDTO? = null
)

data class StatDTO(
    var name: String? = null,
    var url: String? = null
)

data class MovesDTO(
    var move: MoveDTO? = null,
    var version_group_details: List<VersionGroupDetailsDTO>? = null
)

data class MoveDTO(
    var name: String? = null,
    var url: String? = null
)

data class VersionGroupDetailsDTO(
    var level_learned_at: Int? = null,
    var move_learn_method: MoveLearnMethodDTO? = null,
    var version_group: VersionGroupDTO? = null
)

data class MoveLearnMethodDTO(
    var name: String? = null,
    var url: String? = null
)

data class VersionGroupDTO(
    var name: String? = null,
    var url: String? = null
)

data class SpritesDTO(
    var back_default: String? = null,
    var back_female: String? = null,
    var back_shiny: String? = null,
    var back_shiny_female: String? = null,
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null,
    var other: OtherDTO? = null,
    var versions: VersionsDTO? = null,

)

data class OtherDTO(
    var dream_world: DreamWorldDTO? = null,
    var home: HomeDTO? = null,
    @field:JsonProperty(value = "official-artwork")
    var officialArtwork: OfficialArtworkDTO? = null
)

data class DreamWorldDTO(
    var front_default: String? = null,
    var front_female: String? = null
)

data class HomeDTO(
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null
)

data class OfficialArtworkDTO(
    var front_default: String? = null
)

data class VersionsDTO(
    @field:JsonProperty(value = "generation-i")
    var generationI: GenerationIDTO? = null,
    @field:JsonProperty(value = "generation-ii")
    var generationII: GenerationIIDTO? = null,
    @field:JsonProperty(value = "generation-iii")
    var generationIII: GenerationIIIDTO? = null,
    @field:JsonProperty(value = "generation-iv")
    var generationIV: GenerationIVDTO? = null,
    @field:JsonProperty(value = "generation-v")
    var generationV: GenerationVDTO? = null,
    @field:JsonProperty(value = "generation-vi")
    var generationVI: GenerationVIDTO? = null,
    @field:JsonProperty(value = "generation-vii")
    var generationVII: GenerationVIIDTO? = null,
    @field:JsonProperty(value = "generation-viii")
    var generationVIII: GenerationVIIIDTO? = null
)

data class GenerationIDTO(
    @field:JsonProperty(value = "red-blue")
    var redBlue: RedBlueDTO? = null,
    var yellow: YellowDTO? = null,
)

data class RedBlueDTO(
    var back_default: String? = null,
    var back_gray: String? = null,
    var back_transparent: String? = null,
    var front_default: String? = null,
    var front_gray: String? = null,
    var front_transparent: String? = null
)

data class YellowDTO(
    var back_default: String? = null,
    var back_gray: String? = null,
    var back_transparent: String? = null,
    var front_default: String? = null,
    var front_gray: String? = null,
    var front_transparent: String? = null
)

data class GenerationIIDTO(
    var crystal: CrystalDTO? = null,
    var gold: GoldDTO? = null,
    var silver: SilverDTO? = null
)

data class CrystalDTO(
    var back_default: String? = null,
    var back_shiny: String? = null,
    var back_shiny_transparent: String? = null,
    var back_transparent: String? = null,
    var front_default: String? = null,
    var front_shiny: String? = null,
    var front_shiny_transparent: String? = null,
    var front_transparent: String? = null
)

data class GoldDTO(
    var back_default: String? = null,
    var back_shiny: String? = null,
    var front_default: String? = null,
    var front_shiny: String? = null,
    var front_transparent: String? = null
)

data class SilverDTO(
    var back_default: String? = null,
    var back_shiny: String? = null,
    var front_default: String? = null,
    var front_shiny: String? = null,
    var front_transparent: String? = null
)

data class GenerationIIIDTO(
    var emerald: EmeraldDTO? = null,
    @field:JsonProperty(value = "firered-leafgreen")
    var fireredLeafgreen: FireRedLeafGreenDTO? = null,
    @field:JsonProperty(value = "ruby-sapphire")
    var rubySapphire: RubySapphireDTO? = null
)

data class EmeraldDTO(
    var front_default: String? = null,
    var front_shiny: String? = null
)

data class FireRedLeafGreenDTO(
    var back_default: String? = null,
    var back_shiny: String? = null,
    var front_default: String? = null,
    var front_shiny: String? = null
)

data class RubySapphireDTO(
    var back_default: String? = null,
    var back_shiny: String? = null,
    var front_default: String? = null,
    var front_shiny: String? = null
)

data class GenerationIVDTO(
    @field:JsonProperty(value = "diamond-pearl")
    var diamondPearl: DiamondPearlDTO? = null,
    @field:JsonProperty(value = "heartgold-soulsilver")
    var heartgoldSoulsilver: HeartGoldSoulSilverDTO? = null,
    var platinum: PlatinumDTO? = null
)

data class DiamondPearlDTO(
    var back_default: String? = null,
    var back_female: String? = null,
    var back_shiny: String? = null,
    var back_shiny_female: String? = null,
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null
)

data class HeartGoldSoulSilverDTO(
    var back_default: String? = null,
    var back_female: String? = null,
    var back_shiny: String? = null,
    var back_shiny_female: String? = null,
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null
)

data class PlatinumDTO(
    var back_default: String? = null,
    var back_female: String? = null,
    var back_shiny: String? = null,
    var back_shiny_female: String? = null,
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null
)

data class GenerationVDTO(
    @field:JsonProperty(value = "black-white")
    var blackWhite: BlackWhiteDTO? = null
)

data class BlackWhiteDTO(
    var animated: AnimatedDTO? = null,
    var back_default: String? = null,
    var back_female: String? = null,
    var back_shiny: String? = null,
    var back_shiny_female: String? = null,
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null
)

data class AnimatedDTO(
    var back_default: String? = null,
    var back_female: String? = null,
    var back_shiny: String? = null,
    var back_shiny_female: String? = null,
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null
)

data class GenerationVIDTO(
    @field:JsonProperty(value = "omegaruby-alphasapphire")
    var omegaRubyAlphaSapphire: OmegaRubyAlphaSapphireDTO? = null,
    @field:JsonProperty(value = "x-y")
    var xY: XYDTO? = null
)

data class OmegaRubyAlphaSapphireDTO(
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null
)

data class XYDTO(
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null
)

data class GenerationVIIDTO(
    var icons: IconsDTO? = null,
    @field:JsonProperty(value = "ultra-sun-ultra-moon")
    var ultraSunUltraMoon: UltraSunUltraMoon? = null
)

data class IconsDTO(
    var front_default: String? = null,
    var front_female: String? = null
)

data class UltraSunUltraMoon(
    var front_default: String? = null,
    var front_female: String? = null,
    var front_shiny: String? = null,
    var front_shiny_female: String? = null
)

data class GenerationVIIIDTO(
    var icons: IconsIIDTO? = null
)

data class IconsIIDTO(
    var front_default: String? = null,
    var front_female: String? = null
)

data class SpeciesDTO(
    var name: String? = null,
    var url: String? = null
)

data class HeldItemsDTO(
    var item: ItemDTO? = null,
    var version_details: List<VersionDetailsDTO>? = null
)

data class ItemDTO(
    var name: String? = null,
    var url: String? = null
)

data class VersionDetailsDTO(
    var rarity: Int? = null,
    var version: VersionIIDTO? = null
)

data class VersionIIDTO(
    var name: String? = null,
    var url: String? = null
)

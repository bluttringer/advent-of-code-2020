package org.advent.of.code


class PassportExtractor(private val data: List<String>) {
    fun extractPassports(): List<Passport> {
        val passportsData = data.joinToString(" ") { if (it.isBlank()) "@" else it }
        return passportsData.split("@").map { Passport(it) }
    }
}

class Passport(fields: String) {

    val fieldsMap = fields.split(" ")
        .filter { it.isNotBlank() }
        .map { it.split(":")[0] to it.split(":")[1] }
        .toMap()

    fun isValid(): Boolean {
        return fieldsMap.containsKey("byr")
                && fieldsMap.containsKey("iyr")
                && fieldsMap.containsKey("eyr")
                && fieldsMap.containsKey("hgt")
                && fieldsMap.containsKey("hcl")
                && fieldsMap.containsKey("ecl")
                && fieldsMap.containsKey("pid")
    }

    fun isValidStrict(): Boolean {

        if (isValid()) {
            val byr = fieldsMap["byr"]
            if (byr?.length != 4)
                return false
            val byrInt = Integer.parseInt(byr)
            if (byrInt < 1920 || byrInt > 2002) {
                return false
            }

            val iyr = fieldsMap["iyr"]
            if (iyr?.length != 4)
                return false
            val iyrInt = Integer.parseInt(iyr)
            if (iyrInt < 2010 || iyrInt > 2020) {
                return false
            }

            val eyr = fieldsMap["eyr"]
            if (eyr?.length != 4)
                return false
            val eyrInt = Integer.parseInt(eyr)
            if (eyrInt < 2020 || eyrInt > 2030) {
                return false
            }

            val hgt = fieldsMap["hgt"]
            val hgtRegex = Regex("(\\d+)(cm|in)")
            if (!hgtRegex.matches(hgt!!)) {
                return false
            }
            val groupshgt = hgtRegex.find(hgt!!)!!.groupValues
            val hgtNum = Integer.parseInt(groupshgt[1])
            val hgtUnit = groupshgt[2]
            if (hgtUnit != "cm" && hgtUnit != "in") {
                return false
            }
            if (hgtUnit == "cm" && (hgtNum < 150 || hgtNum > 193)) {
                return false
            }
            if (hgtUnit == "in" && (hgtNum < 59 || hgtNum > 76)) {
                return false
            }

            val hcl = fieldsMap["hcl"]
            val hclRegex = Regex("#[0-9a-f]{6}")
            if (!hclRegex.matches(hcl!!)) {
                return false
            }

            val ecl = fieldsMap["ecl"]
            if (ecl != "amb" &&
                ecl != "blu" &&
                ecl != "brn" &&
                ecl != "gry" &&
                ecl != "grn" &&
                ecl != "hzl" &&
                ecl != "oth"
            ) {
                return false
            }

            val pid = fieldsMap["pid"]
            val pidRegex = Regex("\\d{9}")
            if (!pidRegex.matches(pid!!)) {
                return false
            }

            return true
        }

        return false
    }

}


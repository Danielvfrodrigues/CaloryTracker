package com.plcoding.core.data.preferences

import android.content.SharedPreferences
import com.plcoding.core.domain.model.ActivityLevel
import com.plcoding.core.domain.model.Gender
import com.plcoding.core.domain.model.GoalType
import com.plcoding.core.domain.model.UserInfo
import com.plcoding.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharePref: SharedPreferences
) : Preferences {
    override fun saveGender(gender: Gender) {
        sharePref.edit()
            .putString(Preferences.KEY_GENDER, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharePref.edit()
            .putInt(Preferences.KEY_AGE, age)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharePref.edit()
            .putFloat(Preferences.KEY_WEIGHT, weight)
            .apply()
    }

    override fun saveWeight(height: Int) {
        sharePref.edit()
            .putInt(Preferences.KEY_HEIGHT, height)
            .apply()
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        sharePref.edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL, level.name)
            .apply()
    }

    override fun saveGoalType(type: GoalType) {
        sharePref.edit()
            .putString(Preferences.KEY_GOAL_TYPE, type.name)
            .apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharePref.edit()
            .putFloat(Preferences.KEY_CARB_RATIO, ratio)
            .apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharePref.edit()
            .putFloat(Preferences.KEY_PROTEIN_RATIO, ratio)
            .apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharePref.edit()
            .putFloat(Preferences.KEY_FAT_RATIO, ratio)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharePref.getInt(Preferences.KEY_AGE, -1)
        val height = sharePref.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharePref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val genderString = sharePref.getString(Preferences.KEY_GENDER, null)
        val activityLevelString = sharePref.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalType = sharePref.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharePref.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharePref.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharePref.getFloat(Preferences.KEY_FAT_RATIO, -1f)

        return UserInfo(
            age = age,
            height = height,
            weight = weight,
            gender = Gender.fromString(genderString ?: ""),
            activityLevel = ActivityLevel.fromString(activityLevelString ?: ""),
            goalType = GoalType.fromString(goalType ?: ""),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }

}
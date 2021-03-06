package com.arcusys.valamis.learningpath.services.impl.actions

import slick.driver.JdbcProfile
import slick.lifted.TableQuery

/**
  * Created by pkornilov on 6/6/17.
  */
class RecommendedCompetenceDBIOActions(profile: JdbcProfile)
  extends BaseCompetenceDBIOActions(profile) {

  override def competencesTQ: TableQuery[RecommendedCompetenceTable] = recommendedCompetencesTQ
}

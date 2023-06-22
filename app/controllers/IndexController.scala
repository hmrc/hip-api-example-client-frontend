/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers


import play.api.i18n.I18nSupport
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import uk.gov.hmrc.http.HttpReads.Implicits._
import uk.gov.hmrc.http.HttpReads.is2xx
import uk.gov.hmrc.http.client.HttpClientV2
import uk.gov.hmrc.http.{HttpResponse, StringContextOps}
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendBaseController
import views.html.IndexView

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class IndexController @Inject()(
                                 val controllerComponents: MessagesControllerComponents,
                                 view: IndexView,
                                 httpClient: HttpClientV2,
                                 servicesConfig: ServicesConfig
                               ) (implicit ec: ExecutionContext) extends FrontendBaseController with I18nSupport {

  def onPageLoad: Action[AnyContent] = Action.async { implicit request =>
    Future.successful(Ok(view()))
  }

  def onSubmit(): Action[AnyContent] = Action.async {
      implicit request => {
        val value = url"${servicesConfig.baseUrl("hip-api-example-client")}/hip-api-example-client/make-example-request"
        Console.println(s"Value: ${value.toString}")
        httpClient
          .get(value)
          .execute[HttpResponse]
          .map(response => {
            if (is2xx(response.status)) {
              Redirect(routes.ResponseController.onPageLoad(response.body))
            } else {
              Redirect(routes.ResponseController.onPageLoad(s"Response status was ${response.status}"))
            }
          })
      }
  }
}

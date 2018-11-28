import {
  NgModule,
  ModuleWithProviders,
  SkipSelf,
  Optional
} from "@angular/core";
import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { Configuration } from "./configuration";

import { ProductControllerService } from "./api/productController.service";
import { StudentControllerService } from "./api/studentController.service";

@NgModule({
  imports: [CommonModule, HttpClientModule],
  declarations: [],
  exports: [],
  providers: [ProductControllerService, StudentControllerService]
})
export class ApiModule {
  public static forRoot(
    configurationFactory: () => Configuration
  ): ModuleWithProviders {
    return {
      ngModule: ApiModule,
      providers: [{ provide: Configuration, useFactory: configurationFactory }]
    };
  }

  constructor(@Optional() @SkipSelf() parentModule: ApiModule) {
    if (parentModule) {
      throw new Error(
        "ApiModule is already loaded. Import your base AppModule only."
      );
    }
  }
}

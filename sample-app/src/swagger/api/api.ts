export * from './productController.service';
import { ProductControllerService } from './productController.service';
export * from './studentController.service';
import { StudentControllerService } from './studentController.service';
export const APIS = [ProductControllerService, StudentControllerService];

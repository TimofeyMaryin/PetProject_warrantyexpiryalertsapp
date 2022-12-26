package android.realproject.warrantyexpiryalertsapp.data.navigation


/**
 * MainScreen - фрагмент главного экрана
 * HelpFulInfoScreen - фрагмент, в котором будет обьясненно полезность использования этого приложения
 * AllCategoryScreen - просто фрагмент, в котором будет выведены все категории для продуктов
 * CreateProductScreen - фрагмент, где будет создан новый продукт для юзера
 * SettingsScreen - фрагмент настроек
 *
 * ProfileUser - профиль юзера
 * ProductItemScreen - ну это уже фрагмент, где будет выведена вся инфа по товару....
 * CategoryProductScreen - фрагмент, который будет выводить список товаров конкретной категории
 */

sealed class Screen(val route: String){
    object MainScreen: Screen(route = "main_screen")
    object AllCategoryScreen: Screen(route = "all_category_screen")
    object CreateProductScreen: Screen(route = "create_product_screen")
    object AdditionallyScreen: Screen(route = "additionally_screen")

    object CategoryProductScreen: Screen(route = "category_screen_item")
    object ProfileUser: Screen(route = "user_info_screen")
    object ProductItemScreen: Screen(route = "product_item_screen")

    object SelectImageFromArchiveScreen: Screen(route = "select_image_from_archive_screen")
    object ShowDetailsScreen: Screen(route = "show_details_screen")
    object SelectImageCategory: Screen(route = "select_image_category")

    object OnBoarding: Screen(route = "onboarding_screen")
    object SelectUserPhoto: Screen(route = "select_image_user")

    object SplashScreen: Screen(route = "splash_screen")
}

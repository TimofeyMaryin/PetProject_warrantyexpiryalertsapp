package android.realproject.warrantyexpiryalertsapp.utils

import android.realproject.warrantyexpiryalertsapp.R
import android.realproject.warrantyexpiryalertsapp.model.AdditionallyApplicationModel
import android.realproject.warrantyexpiryalertsapp.model.CurrencyModel
import android.realproject.warrantyexpiryalertsapp.model.MainHintModel
import android.realproject.warrantyexpiryalertsapp.model.PhotoCategoryModel

const val PRODUCT_ITEM_ARGUMENT = "count_item"
const val INDEX_PRODUCT_NAME = 0
const val INDEX_PRODUCT_PRICE = 1
const val INDEX_PRODUCT_GUARANTEE = 2


val ADDITIONALLY_APPLICATION_ITEM = listOf(
    AdditionallyApplicationModel(R.string.hint_title_1, 5, R.string.hint_content_1, null),
    AdditionallyApplicationModel(R.string.hint_title_2, 10, R.string.hint_content_2, null),
    AdditionallyApplicationModel(R.string.hint_title_3, 8, R.string.hint_content_3, null),
    AdditionallyApplicationModel(R.string.hint_title_4, 17, R.string.hint_content_4, null),
    AdditionallyApplicationModel(R.string.hint_title_5, 10, R.string.hint_content_5, null)
)

val CURRENCY_ITEMS = listOf(
    CurrencyModel("$", "Доллар", R.drawable.usa_flag),
    CurrencyModel("₽", "Рубль", R.drawable.russia_flag),
    CurrencyModel("€", "Евро", R.drawable.europ_flag),
    CurrencyModel("¥", "Юань", R.drawable.japan_flag),
    CurrencyModel("₤", "Фунт", R.drawable.england_flag),
)




const val APPLE_CATEGORY = "Apple"
const val CAR_CATEGORY = "Автомобили"
const val MICRO_ELECTRONICS_CATEGORY = "Микроэлектроника"
const val FOR_CHILD_CATEGORY = "Для детей"
const val HOBBIES = "Развлечения"
const val F0R_STUDY = "Для учебы"
const val FOR_JOB = "Для работы"
const val INNOVATION = "Иновации"
const val INVESTMENTS = "Инвестиции"

val listOfIphoneImage = listOf(
    "https://i.pinimg.com/236x/22/6d/f2/226df2d88df0b8571244a4a289698ace.jpg",
    "https://i.pinimg.com/236x/eb/86/fe/eb86fef98550d8b9447d25e709af6f88.jpg",
    "https://i.pinimg.com/236x/77/2e/77/772e77ed6689b0fce2afa4935e49e610.jpg",
    "https://i.pinimg.com/236x/0e/a6/84/0ea6843c325d35d71994a829bd413a62.jpg",
    "https://i.pinimg.com/236x/51/c2/af/51c2af1c8f3eced2201246bad1c5dab2.jpg",
    "https://i.pinimg.com/236x/5f/41/a2/5f41a2f7b68705cf0e2546331d2eee48.jpg",
    "https://i.pinimg.com/236x/61/4b/9e/614b9e6de07af199e24a297dd7d5de8c.jpg",
    "https://i.pinimg.com/236x/8c/96/85/8c96853b6161c6bc40f3ba960192212e.jpg",
)
val listOfCarCategory = listOf(
    "https://i.pinimg.com/236x/77/02/ca/7702ca5b7bd9f1ed11e6c405203e5383.jpg",
    "https://i.pinimg.com/236x/e8/33/60/e8336015cda776546253a0977982fe75.jpg",
    "https://i.pinimg.com/236x/13/68/ca/1368ca0dca1b67913e2ec76caadd3001.jpg",
    "https://i.pinimg.com/236x/e8/8a/bf/e88abf34242ef485cc33f59a825ed0e4.jpg",
    "https://i.pinimg.com/236x/c1/68/d1/c168d1fc69607264ab7f9add0095d052.jpg",
    "https://i.pinimg.com/236x/b4/51/c5/b451c538c14fcf6e94f4309116c1d4d1.jpg",
    "https://i.pinimg.com/236x/be/6f/18/be6f182cc3cdc55f6224c9dcef749ace.jpg"
)
val listOfMicroElectronicsCategory = listOf(
    "https://i.pinimg.com/564x/14/f2/37/14f23734140e039a37558390f02fa0de.jpg",
    "https://i.pinimg.com/236x/5a/53/0c/5a530ccae9fbf4958da437a57147528d.jpg",
    "https://i.pinimg.com/236x/43/37/1d/43371d4b5b1ac827b57cf5c6decb7de2.jpg",
    "https://i.pinimg.com/236x/6d/8f/99/6d8f99c4579011c6d3f22611e6d74515.jpg",
    "https://i.pinimg.com/236x/58/a0/12/58a012bc59501f7df8fbe37b443d43a4.jpg",
    "https://i.pinimg.com/236x/bf/ff/ca/bfffca9ad2990f8f5fdd2a85e344b7a3.jpg",
    "https://i.pinimg.com/236x/7f/07/4a/7f074af1f5783ededff2a373afe13839.jpg",
    "https://i.pinimg.com/236x/ab/ed/8b/abed8bb22ebee5f095b27d06d1c7f112.jpg"
)
val listOfChildCategory = listOf(
    "https://i.pinimg.com/236x/69/72/90/697290794d2e4273318bd72c13621a2e.jpg",
    "https://i.pinimg.com/236x/20/16/55/201655c7c33344b3e26824490edf952e.jpg",
    "https://i.pinimg.com/236x/80/f1/e8/80f1e8e3e66f958c3cbd404f14cef3eb.jpg",
    "https://i.pinimg.com/236x/e0/57/1f/e0571f4330e2702b99eeffdf4315a4db.jpg",
    "https://i.pinimg.com/236x/ba/99/d5/ba99d5a17376033a0597ed75429ed429.jpg",
    "https://i.pinimg.com/236x/f6/25/d0/f625d0a67e25b521a799ec9c3423e596.jpg",
    "https://i.pinimg.com/236x/07/38/f2/0738f28fb3de9e5287dda8520bf433d9.jpg",
    "https://i.pinimg.com/236x/d6/10/09/d61009503f3c0b61cbcfc9979dad91ff.jpg",
)

val listOfHobbies = listOf(
    "https://i.pinimg.com/564x/44/f9/4c/44f94c2794a491c4687e76a02fa73622.jpg",
    "https://i.pinimg.com/236x/4d/24/b1/4d24b1806aae7df7291e8eb4250d407d.jpg",
    "https://i.pinimg.com/236x/39/7f/e2/397fe2337fb3ce0ac3e3b74a757aea93.jpg",
    "https://i.pinimg.com/236x/ba/93/cc/ba93cc80b84734c1946737d190c8a6ca.jpg",
    "https://i.pinimg.com/236x/61/d5/90/61d590881a539fa7f31396f17cacfead.jpg",
    "https://i.pinimg.com/236x/35/e3/0e/35e30e69d46883ab5f0f9a4e63325f96.jpg",
    "https://i.pinimg.com/236x/35/e3/0e/35e30e69d46883ab5f0f9a4e63325f96.jpg",
    "https://i.pinimg.com/236x/35/e3/0e/35e30e69d46883ab5f0f9a4e63325f96.jpg",
    "https://i.pinimg.com/236x/35/e3/0e/35e30e69d46883ab5f0f9a4e63325f96.jpg",
    "https://i.pinimg.com/236x/6c/cf/9a/6ccf9ae1aa55d444e0530c158729345d.jpg",
)

val listOfStudy = listOf(
    "https://i.pinimg.com/236x/6f/9e/0c/6f9e0cd357d88b67449460337461cf1e.jpg",
    "https://i.pinimg.com/236x/7e/b2/fb/7eb2fbaa259b7e0f6fbd878e513b56da.jpg",
    "https://i.pinimg.com/236x/7e/b2/fb/7eb2fbaa259b7e0f6fbd878e513b56da.jpg",
    "https://i.pinimg.com/236x/e8/0d/02/e80d023dd7d0e3de0cf5fdf8a5aaa80d.jpg",
    "https://i.pinimg.com/236x/54/4c/e4/544ce4e3be63cdafdd64ab937b48d08b.jpg",
    "https://i.pinimg.com/564x/0d/4a/a1/0d4aa16fe31dba498c27f3850cdf0e80.jpg",
    "https://i.pinimg.com/236x/a3/89/c2/a389c2dcaafe6399f54ac12eac71ecf7.jpg",
    "https://i.pinimg.com/236x/97/9c/73/979c73addd946e53fd914c6c130039e7.jpg",
    "https://i.pinimg.com/236x/bb/01/96/bb0196962353691be30e18ce4e830c5a.jpg",
    "https://i.pinimg.com/236x/e6/e2/19/e6e219e31ef4c0fd948d724d01a83468.jpg",
    "https://i.pinimg.com/236x/d0/28/b8/d028b8a7fcb9daed23a718c7d759f193.jpg",
    "https://i.pinimg.com/236x/f6/18/e0/f618e0358f53a85299f5e728efbbf186.jpg",
)

val listOfJob = listOf(
    "https://i.pinimg.com/236x/a9/e3/38/a9e338286047594663e5349a1cf6ef6a.jpg",
    "https://i.pinimg.com/236x/01/c2/df/01c2df96374a3011a8d6ae294d846ae1.jpg",
    "https://i.pinimg.com/236x/54/fa/1c/54fa1ce0f21cb91c9a571855ca83d71a.jpg",
    "https://i.pinimg.com/236x/19/a1/2d/19a12df205be9b2c405316b2b0a9eb0c.jpg",
    "https://i.pinimg.com/236x/13/39/c5/1339c503c0189c2d3ec817b74e1d7cf2.jpg",
    "https://i.pinimg.com/236x/64/92/d1/6492d1c6ec7654d177ea97319f400cb6.jpg",
    "https://i.pinimg.com/564x/1a/3c/15/1a3c159d0539e928c59121d648dc4bde.jpg",
    "https://i.pinimg.com/236x/5c/41/7a/5c417ac2eb5995321c737a091b69524e.jpg"
)

val listOfInnovation = listOf(
    "https://i.pinimg.com/564x/03/2b/b4/032bb4387d0796e02d7e23ac92adea99.jpg",
    "https://i.pinimg.com/236x/e6/02/cb/e602cb777300c8e23ccf53d36a960a15.jpg",
    "https://i.pinimg.com/236x/24/c3/59/24c359d1d6b943854be53a00c782da5e.jpg",
    "https://i.pinimg.com/236x/4d/8c/55/4d8c559a20d1bc6e505d940288261648.jpg",
    "https://i.pinimg.com/236x/49/70/55/497055bda99a76e346b87214bfe7de51.jpg",
    "https://i.pinimg.com/236x/03/85/06/038506c3561162544a1c89afa4554cfe.jpg",
    "https://i.pinimg.com/236x/4a/66/e1/4a66e127b0ba97f51cfe330ce9017ce9.jpg",
    "https://i.pinimg.com/236x/59/90/25/5990251fe79af79ca5d540dec8924d38.jpg",
    "https://i.pinimg.com/236x/ff/c3/d6/ffc3d67fcaed428671aea9cf64bf57c7.jpg",
    "https://i.pinimg.com/236x/bc/35/4e/bc354e906646463efa80d588c1c055f3.jpg",
    "https://i.pinimg.com/236x/47/81/b8/4781b88fdd68c5a72aea0277587a00ae.jpg"
)


val listOfInvestments = listOf(
    "https://i.pinimg.com/236x/4f/ca/94/4fca943adca89f276c59dfb4060ca1d2.jpg",
    "https://i.pinimg.com/236x/95/03/6e/95036ed5c360034764c356dabffc5519.jpg",
    "https://i.pinimg.com/236x/bd/15/21/bd1521122987ecf20384a4fb47dfb8c9.jpg",
    "https://i.pinimg.com/236x/76/d6/d5/76d6d5835fd26b00b63d3170d94e85b4.jpg",
    "https://i.pinimg.com/236x/52/28/df/5228df0eefdda91bf8619502258b0121.jpg",
    "https://i.pinimg.com/236x/8b/66/35/8b663506902af52baf204940e972d264.jpg",
    "https://i.pinimg.com/236x/84/8f/f6/848ff60b95a136629013739de3ff7e02.jpg",
    "https://i.pinimg.com/236x/7d/4c/4b/7d4c4b85290d936bd638d45a1f8c9997.jpg",
    "https://i.pinimg.com/236x/00/3f/f8/003ff83bcd14b9fdc2e76b063c27a5cf.jpg",
    "https://i.pinimg.com/236x/93/d5/54/93d5540ced24ef9c6c252d1422f5b936.jpg",
    "https://i.pinimg.com/236x/b6/7b/92/b67b9277ff1b535c426f145197e8692c.jpg",
    "https://i.pinimg.com/236x/04/49/a7/0449a7589bc852a502d95273df262278.jpg"
)

val PHOTO_CATEGORY = listOf(
    PhotoCategoryModel(APPLE_CATEGORY, "https://i.pinimg.com/236x/dc/ad/84/dcad84c0a4d62b3bda8cc287e0447cae.jpg", listOfIphoneImage),
    PhotoCategoryModel(CAR_CATEGORY, "https://i.pinimg.com/236x/d7/9c/ce/d79cce468c8f74fd867553be9456d14e.jpg", listOfCarCategory),
    PhotoCategoryModel(MICRO_ELECTRONICS_CATEGORY, "https://i.pinimg.com/236x/50/28/3e/50283eb3879467e01eb43f501420bae4.jpg", listOfMicroElectronicsCategory),
    PhotoCategoryModel(FOR_CHILD_CATEGORY, "https://i.pinimg.com/236x/99/0a/ef/990aef3250364aaf474ca69ba50a4f70.jpg", listOfChildCategory),

    PhotoCategoryModel(HOBBIES, "https://i.pinimg.com/236x/d4/e8/04/d4e804020b3af07a45cceb544291868f.jpg", listOfHobbies),
    PhotoCategoryModel(F0R_STUDY, "https://i.pinimg.com/236x/f0/d2/ee/f0d2ee7605e1eb52f4960b6f91d1547f.jpg", listOfStudy),
    PhotoCategoryModel(FOR_JOB, "https://i.pinimg.com/236x/4b/73/aa/4b73aa2d071775966b8328f1f81536f7.jpg", listOfJob ),
    PhotoCategoryModel(INNOVATION, "https://i.pinimg.com/236x/03/2b/b4/032bb4387d0796e02d7e23ac92adea99.jpg", listOfInnovation),
    PhotoCategoryModel(INVESTMENTS, "https://i.pinimg.com/236x/52/bb/a0/52bba0b9a1b43df1ec771e31f34f44f3.jpg", listOfInvestments),
)



val LIST_OF_ICON_BOARDING = listOf(
    R.drawable.icon_one
)

val LIST_OF_HINT_MODEL = listOf(
    MainHintModel(R.drawable.icon_one, "Веселитесь", "Найдите способ веселиться в любой ситуации: смейтесь над своими неудачами, ищите юмор в непредсказуемости жизни. "),
    MainHintModel(R.drawable.icon_two, "Не напрягайтесь по пустякам", "Не берите все слишком серьезно: научитесь смотреть на вещи с разных ракурсов, рассматривать их с юмором. "),
    MainHintModel(R.drawable.icon_three, "Беригите себя", "Слушайте свое тело: если вам хочется сделать перерыв, не стоит терпеть, важно ухаживать за своим здоровьем. "),
    MainHintModel(R.drawable.icon_two, "Не стесняйтесь", "Делитесь своими успехами: радуйтесь своим достижениям и не стесняйтесь с ними поделиться с друзьями и семьей. ".repeat(4)),
    MainHintModel(R.drawable.icon_three, "Не забывайте про себя", "Находите время для себя: не забывайте о своих увлечениях и хобби, находите время для того, чтобы расслабиться и наслажда ".repeat(18)),
    MainHintModel(R.drawable.icon_one, "Б-бытавуха(1)", "Не оставляйте телефон на крыше автомобиля, чтобы он не упал с нее. "),
    MainHintModel(R.drawable.icon_two, "Б-бытавуха(2)", "Не храните картофель в холодильнике, чтобы он не стал твердым. "),
    MainHintModel(R.drawable.icon_three, "Б-бытавуха(3)", "Не пытайтесь набрать номер телефона с помощью клавиатуры компьютера, чтобы не путаться."),
    MainHintModel(R.drawable.icon_two, "Смейтесь", "Смейтесь хотя бы раз в день: смех улучшает настроение и помогает снизить уровень стресса."),
    MainHintModel(R.drawable.icon_three, "Разбавляйте рутину", "Постарайтесь разбавлять рутину чем-то новым: попробуйте новую диету, спортивную деятельность или хобби. "),
    MainHintModel(R.drawable.icon_one, "Не забывай про друзей", "Общайтесь с друзьями и семьей: находите время для общения с людьми, которые вам дорожат. "),
    MainHintModel(R.drawable.icon_two, "#Разнообразние", "Сделайте себе капучино с необычными добавками, например, с корицей или специями."),

)

val randomPhraseStatus = listOf(
    "В детстве время тянется, а потом — бац! И тебе уже пятьдесят.",
    "Мой брат научил меня не обращать внимания на все, что говорят до слова «но».",
    "Настоящие друзья никогда не осуждают друг друга. Они осуждают других людей. Вместе.",
    "Прошу послать меня на курсы повышения зарплаты Читайте больше: https://www.nur.kz/leisure/books/1841723-smesnye-frazy-i-prikolnye-vyrazenia-so-smyslom/",
    "Смогла ли я поселиться в твоем сердце? Да ты вломилась в него, не снимая обуви",
    "Что бы ты хотела от жизни? Домик у моря с видом на настоящего мужчину.",
    "Если твое счастье зависит от того, как поступают другие, то, пожалуй, у тебя действительно есть проблемы.",
    "¿Dónde puedo encontrar el marido para mi tortuga? Hace 300 años necesita casarse con alguien.",
    " Por favor, llámame la princesa de hadas (el compañero mariscal de campo) .",
    "En otros tiempos mi padre trabajó para el kgb y él me mostré la pareja de llaves.",
    "¿Qué propina? Ya dejó un kilo del sebo en la recepción.",
    " Cuídese Usted a mi fantasma doméstico.",
    "¿Y vosotros, los extraterrestres, siempre están tan amables?",
    "¿Que cabrón robó mi leche de chocolate?",
    "The average woman would rather have beauty than brains, because the average man can see better than he can think.",
    "One of the great things about books is sometimes there are some fantastic pictures.",
    "Always remember: you’re unique, just like everyone else.",
    "The road to success is always under construction."
)


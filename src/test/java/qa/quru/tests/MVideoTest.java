package qa.quru.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import qa.quru.page.MVideoPage;

import java.util.stream.Stream;


public class MVideoTest extends BaseTest {
    MVideoPage mVideoPage = new MVideoPage();

    @BeforeEach
    void setBeforeEach() {
        mVideoPage.openWebSite();
    }

    @Tags({
            @Tag("select")
    })

    @ValueSource(strings = {"Смартфоны и гаджеты", "Ноутбуки и компьютеры", "Телевизоры и цифровое ТВ"})
    @ParameterizedTest(name = "После открытия каталога выбираем название категории {0}")
    @DisplayName("Провалиться в каталог для выбора категории товаров")
    void openCatalogToSelectCategoryOfGoodsWhitValueSource(String getCategory) {
        mVideoPage
                .openCatalog()
                .checkResult(getCategory);
    }

    static Stream<String> useValue() {
        return Stream.of("Смартфоны и гаджеты", "Ноутбуки и компьютеры", "Телевизоры и цифровое ТВ");
    }

    @Tags({
            @Tag("select")
    })
    @MethodSource("useValue")
    @ParameterizedTest(name = "После открытия каталога выбираем название категории {0}")
    @DisplayName("Провалиться в каталог для выбора категории товаров")
    void openCatalogToSelectCategoryOfGoodsWhitMethodSource(String getCategory) {
        mVideoPage
                .openCatalog()
                .checkResult(getCategory);
    }

    @Tags({
            @Tag("select")
    })
    @CsvSource(value = {"Аудиотехника | Аудиотехника"},
            delimiter = '|'
    )
    @ParameterizedTest(name = "После открытия страницы {0} в них должны присутствовать заголовки {1}")
    @DisplayName("Провалиться на страницу категорий для проверки заголовка")
    void openCatalogToSelectCategoryOfGoodsWhitCSVSource(String getCategory) {
        mVideoPage
                .openCatalog()
                .clickOnResult(getCategory)
                .checkAnotherPage(getCategory);

    }
}

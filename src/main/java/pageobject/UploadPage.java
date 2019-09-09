package pageobject;

public class UploadPage {

	// documents folder path
	public static final String DOCUMENT_FOLDER = "//*[@id=\"appRoot\"]/div/div[2]/div[5]/main/div/div/div[2]/div[2]/div/div/div/div/div/div/div/div/div[1]/div[1]/div/div/div/a";

	// file upload input
	public static final String UPLOAD_INPUT = "//*[@id=\"RootPage.default.F.A\"]/input[2]";

	// zero byte file upload error element
	public static final String ZERO_BYTE_FILE_UPLOAD_ERROR_ELEMENT = "//*[@id=\"RootPage.default.F.A\"]/div[3]/div/div/div/div[3]/div/div/div/div/div[1]/div/div[2]/div/div[3]";

	// file info meta icon
	public static final String UPLOAD_FILE_META_BTN = "//button[@title='Open the details pane']";

	// file meta details
	public static final String FILE_META_PATH = "#appRoot > div > div.od-BasePage-belowHeader.od-BasePage-belowHeader--flexbox.od-BasePage-belowHeader--reactShell > div.od-BasePage-belowBar > div > div > div > div.InfoPane.od-InfoPane--sm > div.InfoPane-section.InfoPaneSection--information.is-expanded.no-arrow > div.InfoPane-sectionContent > dl > dd:nth-child(10) > div:nth-child(2)";

	// uploaded file clickable path
	public static final String FILE_LINK = "//*[@id=\"appRoot\"]/div/div[2]/div[5]/main/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/a";

	// file content path
	public static final String FILE_EDITOR_FIRST_LINE_1 = "/html/body/div[1]/div[1]/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[1]/div[2]/div[1]/div[4]/div/span/span";

	// file content path
	public static final String FILE_EDITOR_FIRST_LINE = "mtk1";

	// file menu button
	public static final String FILE_OPEN = "//*[@id=\"appRoot\"]/div/div[5]/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div/div/div[1]/div[1]/button";

	// open editor
	public static final String FILE_OPEN_TEXT_EDITOR = "//button[@title='Open in Text Editor']";

	// file save button
	public static final String FILE_SAVE = "//*[@id=\"appRoot\"]/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div[1]/div[1]/button";

	// version history button

	public static final String FILE_VERSION_HISTORY_BTN = "//*[@id=\"appRoot\"]/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div[1]/div[6]/button";

	// new version file link
	public static final String NEW_VERSION_FILE_LINK = "//*[@id=\"appRoot\"]/div/div[5]/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[1]/div/a";

	// old version file link
	public static final String OLD_VERSION_FILE_LINK = "//*[@id=\"appRoot\"]/div/div[5]/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/div/a";

	// delete icon path
	public static final String DELETE_BUTTON = "//button[@title='Delete']";

	// version history close icon
	public static final String VERSION_HISTORY_CLOSE_ICON = "//*[@id=\"appRoot\"]/div/div[5]/div/div/div/div[2]/button/i";

}

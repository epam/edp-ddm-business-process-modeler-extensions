# business-process-modeler-extensions

### Overview

* Camunda Modeler extensions (plugins and element templates)

### Usage

#### Example Setup

1. Download `business-process-modeler-extensions` folder with the latest version.
2. Copy with replacement folder contents in the `resources` sub-folder of your local `{APP_DATA_DIRECTORY}` (where application stored) or [`{USER_DATA_DIRECTORY}`](https://github.com/camunda/camunda-modeler/tree/master/docs/search-paths#user-data-directory) directory.

For local template discovery, create a `.camunda` folder relative in the directory
or any parent directory of the diagrams you are editing and copy `element-templates` and `plugins` there.

#### Applying element-templates

Example of element template extension for digital signature delegate by DSO:

- Make sure that element-templates folder contain *digitalSignatureConnectorDelegate.json*.
- In the `Service Task`, click the `Open Catalog` button, then select this template.
- Fill in the `Payload` field - data to sign.
- Fill in the `X-Access-Token source` field - ceph key of document that contains X-Access-Token.
- In the `Result variable` field, you can specify any name for the output parameter, by default - *response*
  
  | Transient content          |
  |:---------------------------|
  | The output parameter is transient, so in an expression language it can use only in the input / output ratios.|

### License

The business-process-modeler-extensions is Open Source software released under
the [Apache 2.0 license](https://www.apache.org/licenses/LICENSE-2.0).
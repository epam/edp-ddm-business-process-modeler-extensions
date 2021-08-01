# business-process-modeler-extensions

Camunda Modeler extensions (plugins and element templates)

#### Example Setup

1. Go [`here`](https://nexus-mdtu-ddm-edp-cicd.apps.cicd2.mdtu-ddm.projects.epam.com/#browse/browse:extensions)
2. Find `business-process-modeler-extensions` folder
3. There will be a list of folders named as `version.build` (e.g. 0.0.1-SNAPSHOT.12). Choose a folder with latest version.
4. Choose .zip file in opened folder
5. On `Summary` tab on the right click on `Path` link. It will start zip downloading. 
6. Unpack with replacement downloaded zip file in the `resources` sub-folder of your local `{APP_DATA_DIRECTORY}` (where application stored) or [`{USER_DATA_DIRECTORY}`](https://github.com/camunda/camunda-modeler/tree/master/docs/search-paths#user-data-directory) directory.

For local template discovery, create a `.camunda` folder relative in the directory
or any parent directory of the diagrams you are editing and copy `element-templates` and `plugins` there.

#### Element-templates

1.Element template extension for digital signature delegate by DSO:
- Make sure that element-templates folder contain *digitalSignatureConnectorDelegate.json*.
- In the `Service Task`, click the `Open Catalog` button, then select this template.
- Fill in the `Payload` field - data to sign.
- Fill in the `X-Access-Token source` field - ceph key of document that contains X-Access-Token.
- In the `Result variable` field, you can specify any name for the output parameter, by default - *response*
  
  | Transient content          |
  |:---------------------------|
  | The output parameter is transient, so in an expression language it can use only in the input / output ratios.|
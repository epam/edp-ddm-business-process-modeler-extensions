import com.epam.edp.stages.impl.ci.ProjectType
import com.epam.edp.stages.impl.ci.Stage

@Stage(name = "create-archive", buildTool = "any", type = [ProjectType.APPLICATION, ProjectType.LIBRARY])
class CreateArchive {
    Script script

    void run(context) {
        context.archiveName = "business-process-modeler-extensions-${context.codebase.version}.zip"
        script.dir("${context.workDir}") {
            script.zip glob: 'element-templates/**, plugins/**', zipFile: context.archiveName, archive: true
        }
    }
}

return CreateArchive

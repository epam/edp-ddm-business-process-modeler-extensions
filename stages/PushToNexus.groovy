package com.epam.edp.stages.impl.ci.impl.getversion


import com.epam.edp.stages.impl.ci.ProjectType
import com.epam.edp.stages.impl.ci.Stage

@Stage(name = "push-nexus", buildTool = "any", type = [ProjectType.APPLICATION, ProjectType.LIBRARY])
class PushToNexus {
    Script script

    void run(context) {
        script.dir("${context.workDir}") {
            script.nexusArtifactUploader(
                    nexusVersion: 'nexus3',
                    protocol: 'http',
                    nexusUrl: "${context.nexus.host}:${context.nexus.port}",
                    groupId: 'com.epam.digital.data.platform',
                    version: context.codebase.version,
                    repository: 'edp-maven-releases',
                    credentialsId: 'ci.user',
                    artifacts: [
                            [artifactId: "business-process-modeler-extensions",
                             classifier: '',
                             file      : context.archiveName,
                             type      : 'zip']
                    ]
            )
        }
    }
}

return PushToNexus
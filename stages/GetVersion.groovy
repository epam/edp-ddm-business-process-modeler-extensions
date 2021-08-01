package com.epam.edp.stages.impl.ci.impl.getversion


import com.epam.edp.stages.impl.ci.ProjectType
import com.epam.edp.stages.impl.ci.Stage

@Stage(name = "get-version", buildTool = "any", type = [ProjectType.APPLICATION, ProjectType.LIBRARY])
class GetVersion {
    Script script

    def setVersionToArtifact(context) {
        script.sh """
             set -eo pipefail
             kubectl patch codebasebranches.v2.edp.epam.com ${context.codebase.config.name}-${context.git.branch.replaceAll(/\//, "-")} --type=merge -p '{\"status\": {\"build\": "${context.codebase.currentBuildNumber}"}}'
        """
    }

    void run(context) {
        setVersionToArtifact(context)
        context.codebase.vcsTag = "build/${context.codebase.version}"
        context.codebase.isTag = "${context.codebase.version}"
        context.codebase.deployableModuleDir = "${context.workDir}"

        script.println("[JENKINS][DEBUG] Artifact version - ${context.codebase.version}")
        script.println("[JENKINS][DEBUG] VCS tag - ${context.codebase.vcsTag}")
        script.println("[JENKINS][DEBUG] IS tag - ${context.codebase.isTag}")
    }
}

return GetVersion
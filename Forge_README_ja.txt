-------------------------------------------
�\�[�X�̃C���X�g�[�����@
-------------------------------------------
���̃R�[�h�́AMinecraft Forge�̃C���X�g�[�����@�ɏ]���܂��B 
�o�j����MCP�\�[�X�R�[�h�ւ̏����ȃp�b�`���K�p����܂��B
��������MOD���\�z���邽�߂ɕK�v�ȃf�[�^�ƃ��]�b�g�̂������������܂��B

�܂��A�p�b�`�� "�����񂳂�Ă��Ȃ�" MCP�\�[�X�R�[�h(aka
srgnames) - ����͂��Ȃ��������𒼐ڒʏ�̃R�[�h��ǂނ��Ƃ��ł��Ȃ����Ƃ��Ӗ����܂��B


�\�[�X�p�b�N�̃C���X�g�[�����:

��{�I�ȃ\�[�X�̃C���X�g�[��
==============================

���ڍׂȎ菇�ɂ��ẮAForge�̃I�����C���}�j���A��(�p��)���Q�Ƃ��Ă�������:
http://mcforge.readthedocs.io/en/latest/gettingstarted/

Step 1: �R�}���h���C�����J���Azip�t�@�C�����𓀂����t�H���_�Ɉړ����܂��B

Step 2: �_�E�����[�h�����t�@�C�����u���ꂽ�t�H���_�ɃR�}���h�E�B���h�E���\�����ꂽ��A���̂悤�ɓ��͂��܂��B:

Windows�̏ꍇ�A">gradlew setupDecompWorkspace"
Linux/Mac OS: "$./gradlew setupDecompWorkspace"

Step 3: Eclipse�̏ꍇ�A "gradlew eclipse" ��@���Ă�������(Linux Mac�̏ꍇ"./gradlew eclipse" )

IntelliJ���g�p�������ꍇ�́A�菇�������قȂ�܂��B
1. Open IDEA, and import project.
1, IDEA���J���A"�v���W�F�N�g���C���|�[�g"���N���b�N���܂��B
2. build.gradle�t�@�C����I�����ăC���|�[�g���܂��B
3. ����������AIntelliJ����Ď��̃R�}���h�����s���Ă�������:

"gradlew genIntellijRuns" (./gradlew genIntellijRuns)

Step 4:Eclipse�𗘗p����ꍇ�A�Ō�ɁAEclipse���J���A���[�N�X�y�[�X��./eclipse�ɐ؂�ւ��Ă��������B

���Ȃ���IDE�Ƀ��C�u�������Ȃ��ꍇ��A��肪���������ꍇ�́A
 "gradlew --refresh-dependencies"�����s���ă��[�J���L���b�V�������t���b�V�����邱�Ƃ��ł��܂��B
 "gradlew clean"�����s���Ă��ׂĂ����Z�b�g���Ă��������B����̓R�[�h�ɂ͉e�����܂���B

����ł����삵�Ȃ��ꍇ��A
gradle���̏ڍׂɂ��ẮAEsperNet����#ForgeGradle���Q�Ƃ��Ă��������B

Tip:
�}�C���N���t�g�̃\�[�X�R�[�h���C�ɂ��Ȃ��ꍇ�́A 
"setupDecompWorkspace"�����̂����ꂩ�ɒu�������邱�Ƃ��ł��܂��F
"setupDevWorkspace"�F�}�C���N���t�g�����s���邽�߂ɕK�v�ȃA�Z�b�g���p�b�`�A���W���܂����A�l�Ԃ��ǂ߂�\�[�X�R�[�h�͐�������܂���B
"setupCIWorkspace"�FDev�Ɠ����ł����A�A�Z�b�g���_�E�����[�h���܂���B ����́A�ŏ����̍�Ƃ������s�ł��Ȃ����߁A�T�[�o�[���\�z����̂ɕ֗��ł��B

Tip:
setupDecompWorkspace ���g�p����ꍇ�AMinecraft�\�[�X�R�[�h�͕ҏW�\�ȕ��@�Ń��[�N�X�y�[�X�ɒǉ�����܂���B 
Minecraft�͒ʏ�̃��C�u�����̂悤�Ɉ����܂��B �\�[�X�̓h�L�������e�[�V�����⌤���ړI�̂��߂ɗp�ӂ���Ă���A
�ʏ��IDE�� '�Q�ƃ��C�u����'�Z�N�V�����ŃA�N�Z�X�ł��܂��B

Forge�̃\�[�X�̃C���X�g�[��
=========================
MinecraftForge�͂��̃R�[�h�𓯍����AForge�̈ꕔ�Ƃ��ăC���X�g�[�����܂�
�C���X�g�[���v���Z�X�ł́A����ȏ�̏��u�͕K�v����܂���B

LexMano�������ɂ�铮��
=======================
https://www.youtube.com/watch?v=8VEdtQLuLO0&feature=youtu.be

�X�Ȃ邱�Ƃɂ��ẮAForge Forums���Q�Ƃ��Ă��������B
http://www.minecraftforge.net/forum/index.php/topic,14048.0.html

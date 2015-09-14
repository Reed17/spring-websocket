
'use strict';

module.exports = function (grunt) {

    // Load grunt tasks automatically
    require('load-grunt-tasks')(grunt);

    /*
     *   Time how long grunt tasks take to run, this might be important when having complex builds that take forever.
     *   For now just to show how fancy grunt is.
     */
    require('time-grunt')(grunt);

    // init required configurations for each task.
    grunt.initConfig({

            clean: {
                dest: ['dest', 'tmp'],
                tmp: ['tmp']
            },

            'bower-install-simple': {
                options: {
                    color: true,
                    directory: 'bower_components'
                },
                prod: {
                    options: {
                        production: true
                    }
                }
            },

            copy: {
                app: {
                    expand: true,
                    cwd: 'app/',
                    src: ['**', '!**/*.css', '!**/*.js', '!index.html'],
                    dest: 'dest/'
                }
            },

            'bower_concat': {
                all: {
                    dest: 'tmp/js/_bower_app.js',
                    cssDest: 'tmp/css/_bower_style.css'
                }
            },

            concat_css: {
                options: {},
                all: {
                    src: ['tmp/css/_bower_style.css', 'app/css/**/*.css'],
                    dest: 'tmp/css/_all_styles.css'
                }
            },

            concat: {
                options: {
                    separator: ';'
                },
                all: {
                    src: ['tmp/js/_bower_app.js', 'app/js/**/*.js'],
                    dest: 'tmp/js/_all_app.js'
                }
            },

            cssmin: {
                dest: {
                    src: 'tmp/css/_all_styles.css',
                    dest: 'dest/css/style.min.css'
                }
            },

            uglify: {
                dest: {
                    src: 'tmp/js/_all_app.js',
                    dest: 'dest/js/app.min.js'
                }
            },

            processhtml: {
                dest: {
                    files: {
                        'dest/index.html': ['app/index.html']
                    }
                }
            }
        }
    );

    grunt.registerTask('build', [
        'clean:dest',
        'bower-install-simple:prod',
        'copy:app',
        'bower_concat:all',
        'concat_css:all',
        'concat:all',
        'cssmin:dest',
        'uglify:dest',
        'processhtml:dest',
        'clean:tmp'
    ]);

    grunt.registerTask('default', [
        'build'
    ]);
};